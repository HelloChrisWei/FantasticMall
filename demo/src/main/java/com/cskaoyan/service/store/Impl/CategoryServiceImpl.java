package com.cskaoyan.service.store.Impl;

import com.cskaoyan.bean.Category;
import com.cskaoyan.mapper.CategoryMapper;
import com.cskaoyan.service.store.CategoryService;
import com.cskaoyan.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public CategoryReadVO<Category> categoryList() {
        //最外层：date（是个list），有消息和标识数值（sql：搜索为L1的元素
        //date（list）中存储的元素，包括children（list），一级目录的消息
        //children（list）存储的是二级目录的商品，其中只有相关信息（sql：搜索一级目录的id且二级的元素
        CategoryReadVO<Category> categoryReadVO = new CategoryReadVO<>();
        try {
            List<Category> l1 = categoryMapper.getL1();
            //获取到全部的L1级别商品，然后我要查找到其下的所有L2，并将其存入L1下的list集合中
            List<CategoryVO> data = new ArrayList<>();
            for (Category c : l1) {
                Integer id = c.getId();
                //遍历所有一级目录，并将一级目录的属性写入
                List<Category> l2 = categoryMapper.getL2(id);
                CategoryVO categoryVO = new CategoryVO();
                categoryVO.setChildren(l2);
                c2VO(c, categoryVO);
                data.add(categoryVO);
                categoryReadVO.setData(data);
            }
            categoryReadVO.setErrmsg("查询成功");
            categoryReadVO.setErrno(0);
            return categoryReadVO;
        } catch (Exception e) {
            categoryReadVO.setErrmsg("查询失败");
            categoryReadVO.setErrno(1);
            return categoryReadVO;
        }
    }


    @Override
    public ReadVO categoryUpdate(CategoryVO categoryVO) {
        ReadVO<Object> vo = new ReadVO<>();
        Category c = new Category();
        //将前端返回的categoryVO写成一个category--c
        VO2c(categoryVO, c);

        //如果将一级目录修改为二级目录之后，会带着所有的二级目录转到新的一级目录下
        //所以可以在此层做一个判断是否修改了等级，传回一个json后
        // 可以先搜索原来的等级
        //如果由L1→L2，则自己改变level和pid，之后，旗下所有的子类都要改变pid
        //如果由L2→L1，则直接改变level和pid，pid改为0
        //哦哦 那就是都要改变level和pid，不同的是如果是L1→L2，则需要多一步操作，将所有子类都改变
        Category category = categoryMapper.selectByPrimaryKey(categoryVO.getId());
        //上面这步是获取原有数据
        try {
            if (category.getLevel() != categoryVO.getLevel()) {
                //如果修改了level
                if ("L1".equals(category.getLevel())) {
                    //如果原来是L1,想改成L2
                    //先修改自身
                    categoryMapper.updateByPrimaryKeySelective(c);
                    //修改L1下子类，将其pid都改为新父类的pid
                    categoryMapper.updateL2Pid(c.getId(), c.getPid());
                } else {
                    categoryMapper.updateByPrimaryKeySelective(c);
                }
            }
            vo.setErrmsg("修改成功");
            vo.setErrno(0);
        } catch (Exception e) {
            vo.setErrno(1);
            vo.setErrmsg("修改出现了错误");
        }
        return vo;
    }

    @Override
    public SingleReadVO categoryCreate(Category category) {
        SingleReadVO<Category> vo = new SingleReadVO<>();
        try {
            categoryMapper.insert(category);
            vo.setData(categoryMapper.selectByPrimaryKey(category.getId()));
            vo.setErrmsg("新增成功");
            vo.setErrno(0);
            return vo;
        } catch (Exception e) {
            e.printStackTrace();
            vo.setErrno(1);
            vo.setErrmsg("新增失败");
            return vo;
        }
    }

    @Override
    public ReadVO categoryDelete(CategoryVO categoryVO) {
        ReadVO<Category> vo = new ReadVO<>();
        Category c = new Category();
        VO2c(categoryVO, c);
        Category category = categoryMapper.selectByPrimaryKey(categoryVO.getId());
        try {
            if ("L1".equals(category.getLevel())) {
                //如果原来是L1,则除了删除本身还要删除其下所有子类
                categoryMapper.deleteByPrimaryKey(c.getId());
                //获取其下所有L2商品
                List<Category> l2 = categoryMapper.getL2(c.getId());
                for (Category ca:l2) {
                    categoryMapper.deleteByPrimaryKey(ca.getId());
                }
            } else {
                categoryMapper.deleteByPrimaryKey(c.getId());
            }
            vo.setErrmsg("修改成功");
            vo.setErrno(0);
        } catch (Exception e) {
            vo.setErrno(1);
            vo.setErrmsg("修改出现了错误");
        }
        return vo;
    }

    public L1MapVO categoryL1() {
        L1MapVO mapVO = new L1MapVO();
        try {
            List<Category> l1 = categoryMapper.getL1();
            ArrayList<Map> maps = new ArrayList<>();
            for (Category c : l1) {
                HashMap<String, String> map = new HashMap<>();
                map.put("label", c.getName());
                map.put("value", c.getId().toString());
                maps.add(map);
            }
            mapVO.setDate(maps);
            mapVO.setErrmsg("成功");
            mapVO.setErrno(0);
            return mapVO;
        } catch (Exception e) {
            e.printStackTrace();
            mapVO.setErrno(1);
            mapVO.setErrmsg("失败");
            return mapVO;
        }

    }

    private void VO2c(CategoryVO categoryVO, Category c) {
        c.setAddTime(categoryVO.getAddTime());
        c.setDeleted(categoryVO.getDeleted());
        c.setDesc(categoryVO.getDesc());
        c.setIconUrl(categoryVO.getIconUrl());
        c.setId(categoryVO.getId());
        c.setKeywords(categoryVO.getKeywords());
        c.setLevel(categoryVO.getLevel());
        c.setName(categoryVO.getName());
        c.setPicUrl(categoryVO.getPicUrl());
        c.setPid(categoryVO.getPid());
        c.setSortOrder(categoryVO.getSortOrder());
        c.setUpdateTime(categoryVO.getUpdateTime());
    }

    private void c2VO(Category c, CategoryVO categoryVO) {
        categoryVO.setAddTime(c.getAddTime());
        categoryVO.setDeleted(c.getDeleted());
        categoryVO.setDesc(c.getDesc());
        categoryVO.setIconUrl(c.getIconUrl());
        categoryVO.setId(c.getId());
        categoryVO.setKeywords(c.getKeywords());
        categoryVO.setLevel(c.getLevel());
        categoryVO.setName(c.getName());
        categoryVO.setPicUrl(c.getPicUrl());
        categoryVO.setPid(c.getPid());
        categoryVO.setSortOrder(c.getSortOrder());
        categoryVO.setUpdateTime(c.getUpdateTime());
    }
}
