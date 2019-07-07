package com.cskaoyan.service.store.Impl;

import com.cskaoyan.bean.Region;
import com.cskaoyan.bean.RegionExample;
import com.cskaoyan.mapper.RegionMapper;
import com.cskaoyan.service.store.RegionService;
import com.cskaoyan.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    public StoreVO<Region> regionList(){
        StoreVO<Region> rRegionVO = new StoreVO<>();
        try{
            List<Region> regions = regionMapper.selectByExample(new RegionExample());
            rRegionVO.setData(regions);
            rRegionVO.setErrmsg("成功");
            rRegionVO.setErrno(0);
            return rRegionVO;

        }catch (Exception e){
            rRegionVO.setErrmsg("查询有误！");
            rRegionVO.setErrno(1);
            return rRegionVO;
        }
    }

}
