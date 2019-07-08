package com.cskaoyan.service.goods.impl;
import com.cskaoyan.bean.*;
import com.cskaoyan.bean.goods.*;
import com.cskaoyan.mapper.*;
import com.cskaoyan.mapper.goods.*;
import com.cskaoyan.service.goods.GoodsService;
import com.cskaoyan.vo.GoodsHanderVO;
import com.cskaoyan.vo.GoodsPreviewVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    GoodsAttributeMapper goodsAttributeMapper;
    @Autowired
    GoodsProductMapper goodsProductMapper;
    @Autowired
    GoodsSpecificationMapper goodsSpecificationMapper;
    @Autowired
    CategoryMapper categoryMapper;
    @Autowired
    BrandMapper brandMapper;

    @Override
    public GoodsPreviewVO selectGoodsList(GoodsHanderVO handerVO, Integer goodsSn, String name) {
        GoodsExample goodsexample = new GoodsExample();
        //通过criteria构造构造自定义查询条件
        GoodsExample.Criteria criteria = goodsexample.createCriteria();
        if (goodsSn != null){
            //如果用商品编号不为空,添加id字段为goodSn条件
            criteria.andIdEqualTo(goodsSn);
        }else if (name !=null){
            criteria.andNameLike("%" + name + "%");
        }else {
            criteria.getAllCriteria();
        }

        //PageHelper接收的前端数据
        PageHelper.startPage(handerVO.getPage(),handerVO.getLimit());
        //查询所有Goods数据封装成一个list
        List<Goods> goods = goodsMapper.selectByExample(goodsexample);
        PageInfo<Goods> pageInfo = new PageInfo<>(goods);
        //查询total总数据
        int total = (int) pageInfo.getTotal();
        HashMap<String, Object> map = new HashMap<>();
        map.put("items",goods);
        map.put("total",total);
        return  new GoodsPreviewVO("成功",0,map);
    }

    @Override
    public GoodsPreviewVO selectGoodsDetail(Integer id) {
        //获取attributes
        GoodsAttributeExample attributeExample = new GoodsAttributeExample();
        //通过criteria构造构造自定义查询条件
        GoodsAttributeExample.Criteria criteria = attributeExample.createCriteria();
        criteria.andGoodsIdEqualTo(id);
        /*将查询的所有数据封装成一个GoodAttribute的list集合*/
        List<GoodsAttribute> goodsAttributes= goodsAttributeMapper.selectByExample(attributeExample);
        /**
         *    前端返回的是单个GoodsAttribute而不是一个list集合,
         *   创建一个对象数组依次去取list中的值
         */
        //获取list的长度
        int size = goodsAttributes.size();
        GoodsAttribute[ ] goodsAttribute = new GoodsAttribute[size];
        for (int i = 0; i <size ; i++) {
            goodsAttribute[i] = goodsAttributes.get(i);

        }

       // 获取products  GoodsProductExample  GoodsProduct
        GoodsProductExample productExample = new GoodsProductExample();
        //定义自定义查询条件
        GoodsProductExample.Criteria criteria1 = productExample.createCriteria();
        criteria1.andGoodsIdEqualTo(id);
        //将查询数据封装成一个list集合
        List<GoodsProduct> goodsProducts = goodsProductMapper.selectByExample(productExample);
        //获取list集合的长度
        int size1 = goodsProducts.size();
        //创建一个对象数组去依次获取list中的值
        GoodsProduct[] goodsProduct = new GoodsProduct[size1];
        for (int i = 0; i <size1 ; i++) {
            goodsProduct[i] = goodsProducts.get(i);
        }

        //获取goods
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        /**
         * 获取categoryIds 前端展示的是一个数组[id,pid]
         *首先通过商品里面获取categoryId 再由categorymapper通过Id去查询
         *数据库表中的id 和pid 将其封装成一个数组交给前端展示
         */
        Integer categoryId = goods.getCategoryId();
        Category category = categoryMapper.selectIdsById(categoryId);
        //从category中获取id 和pid 将其封装成数组
        Integer[] categoryIds = new Integer[2];
        categoryIds[0] = category.getId();
        categoryIds[1] = category.getPid();

        HashMap<String, Object> map = new HashMap<>();
        map.put("attributes",goodsAttribute);
        map.put("categoryIds",categoryIds);
        map.put("goods",goods);
        map.put("products",goodsProduct);
        return new GoodsPreviewVO("成功",0,map);
    }

    /**
     * brandList中前端只展示id(value)和name(Label)
     * categoryList中前端展示的id 和name 和一个存放了存放了三个id和name的chridren
     * 然后将两个list存放在hashmap中
     */
    @Override
    public GoodsPreviewVO selectCatAnBrand() {
        //获取brandList
        BrandExample brandExample = new BrandExample();
        List<Brand> brandLists = brandMapper.selectByExample(brandExample);
        List<BrandList> goodsCatAndBrandLists = new ArrayList<>();
        for (Brand brand : brandLists){
            BrandList list = new BrandList();
            list.setLabel(brand.getName());
            list.setValue(brand.getId());
            goodsCatAndBrandLists.add(list);
        }
        //获取categoryList
        CategoryExample categoryExample = new CategoryExample();
        List<CategoryList> categoryLists = new ArrayList<>();
        List<Category> categories = categoryMapper.selectByExample(categoryExample);
        for (Category category :categories){
            //获取获取categoryList的id和name
            CategoryList list = new CategoryList();
            list.setLabel(category.getName());
            list.setValue(category.getId());

            List<Category> selectCategoryList = categoryMapper.selectCategoryList(category.getPid());
            List<Children> childrenLists = new ArrayList<>();
            for (Category category1 : selectCategoryList){
                Children list1 = new Children();
                list1.setValue(category1.getId());
                list1.setLabel(category1.getName());
                childrenLists.add(list1);
            }
            list.setChildren(childrenLists);
            categoryLists.add(list);
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("brandList",goodsCatAndBrandLists);
        map.put("categoryList",categoryLists);
        return new GoodsPreviewVO("成功",0,map);
    }

    @Override
public GoodsPreviewVO updateGoods(GoodsUpDateData goodsUpDateData) {
        GoodsPreviewVO previewVO = new GoodsPreviewVO();
        try {
            int i = goodsMapper.updateByPrimaryKey(goodsUpDateData.getGoods());
            if (i == 1){
                previewVO.setErrmsg("更新成功");
                previewVO.setErrno(0);
            }
        }catch (Exception e){
            e.printStackTrace();
            previewVO.setErrmsg("更新失败");
            previewVO.setErrno(500);
        }
        return previewVO;
}

    @Override
    public GoodsPreviewVO deleteGoodsById(Goods goods) {
        GoodsPreviewVO  previewVO = new GoodsPreviewVO();
        try {
            int i = goodsMapper.deleteByPrimaryKey(goods.getId());
            if (i == 1) {
                previewVO.setErrno(0);
                previewVO.setErrmsg("删除成功");
            }
        }catch (Exception e){
            previewVO.setErrno(500);
            previewVO.setErrmsg("删除失败");
        }
        return previewVO;
    }

    /**
     *
     * @param goodsAddData
     * @return new GoodsPreview("添加成功",0,"")
     * attributes goods products specifications
     * 对应的bean类:GoodsAttribute Goods GoodsProduct GoodsSpecification
     */
    @Override
    public GoodsPreviewVO addGoods(GoodsAddData goodsAddData) {
        goodsMapper.insert(goodsAddData.getGoods());
        //获取goodsId
        Integer id = goodsAddData.getGoods().getId();
        GoodsAttribute[] attributes = goodsAddData.getAttributes();
        for (GoodsAttribute attribute :attributes){
            attribute.setGoodsId(id);
            goodsAttributeMapper.insert(attribute);
        }
        GoodsProduct[] products = goodsAddData.getProducts();
        for (GoodsProduct product :products){
            product.setGoodsId(id);
            goodsProductMapper.insert(product);
        }
        GoodsSpecification[] specifications = goodsAddData.getSpecifications();
        for (GoodsSpecification specification :specifications){
            specification.setGoodsId(id);
            goodsSpecificationMapper.insert(specification);
        }
        return new GoodsPreviewVO("添加成功",0,"");
    }


}
