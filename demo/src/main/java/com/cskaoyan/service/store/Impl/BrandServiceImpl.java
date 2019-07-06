package com.cskaoyan.service.store.Impl;

import com.cskaoyan.bean.Brand;
import com.cskaoyan.bean.BrandExample;
import com.cskaoyan.mapper.BrandMapper;
import com.cskaoyan.service.store.BrandService;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.ResultVO;
import com.cskaoyan.vo.SingleReadVO;
import com.cskaoyan.vo.StoreVO;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    BrandMapper brandMapper;

    @Override
    public ReadVO brandList(int page, int limit,String id,String name, String sort, String desc) {
        ReadVO storeVO = new ReadVO();
        try{
            PageHelper.startPage(page,limit);
            String bid = null;
            String bname = null;
            if (id!=null){
                bid = "%"+id+"%";
            }
            if (name!=null){
                bname="%"+name+"%";
            }
            ResultVO<Brand> brandResultVO = new ResultVO<>();
            brandResultVO.setItems(brandMapper.select(bid,bname));
            brandResultVO.setTotal((int)brandMapper.count(bid,bname));
            storeVO.setData(brandResultVO);
            storeVO.setErrmsg("成功");
            storeVO.setErrno(0);
            return storeVO;
        }catch (Exception e){
            storeVO.setErrmsg("查询有误");
            storeVO.setErrno(1);
            return storeVO;
        }


    }

    @Override
    public SingleReadVO<Brand> brandUpdate(Brand brand) {
        int i = brandMapper.updateByPrimaryKey(brand);
        SingleReadVO<Brand> bSVO = new SingleReadVO<>();
        if (i == 1 ){
            Brand brand1 = brandMapper.selectByPrimaryKey(brand.getId());
            bSVO.setData(brand1);
            bSVO.setErrmsg("成功");
            bSVO.setErrno(0);
            return bSVO;
        }else{
            bSVO.setErrmsg("修改失败");
            bSVO.setErrno(1);
            return bSVO;
        }

    }

    @Override
    public SingleReadVO brandDelete(Brand brand) {
        SingleReadVO<Object> VO = new SingleReadVO<>();
        int i = brandMapper.deleteByPrimaryKey(brand.getId());
        if (i == 1 ){
            VO.setErrmsg("成功");
            VO.setErrno(0);
            return VO;
        }else{
            VO.setErrmsg("删除失败");
            VO.setErrno(1);
            return VO;
        }
    }
}
