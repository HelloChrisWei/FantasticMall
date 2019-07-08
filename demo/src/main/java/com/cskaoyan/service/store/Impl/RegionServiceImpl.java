package com.cskaoyan.service.store.Impl;

import com.cskaoyan.bean.Region;
import com.cskaoyan.bean.RegionExample;
import com.cskaoyan.mapper.RegionMapper;
import com.cskaoyan.service.store.RegionService;
import com.cskaoyan.vo.RegionReadVO;
import com.cskaoyan.vo.ResultVO;
import com.cskaoyan.vo.StoreVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionMapper regionMapper;

    public StoreVO<Region> regionList(){
        //先获取全部的type为1的地区
        StoreVO storeVO = new StoreVO();
        try {
            byte b = (byte) 1;
            Byte b1 = b;
            byte bb = (byte) 2;
            Byte b2 = bb;
            byte bbb = (byte) 3;
            Byte b3 = bbb;
            List<Region> type1 = regionMapper.selectByType(b1);

            ArrayList list1 = new ArrayList();

            for (Region r1 : type1) {
                RegionReadVO votype1 = new RegionReadVO();
                //这是获取在当前一级区域下的二级区域
                List<Region> type2 = regionMapper.selectByPidAndType(b2, r1.getId());

                ArrayList list2 = new ArrayList();
                for (Region r2 : type2) {
                    RegionReadVO votype2 = new RegionReadVO();
                    //获取在当前二级目录下的三级目录

                    List<Region> type3 = regionMapper.selectByPidAndType(b3, r2.getId());
                    ArrayList list3 = new ArrayList();
                    for (Region r3 : type3) {
                        RegionReadVO votype3 = new RegionReadVO();

                        //获得了type3的信息存进了votype3中
                        getType(votype3, r3);
                        list3.add(votype3);
                    }
                    votype2.setChildren(list3);
                    getType(votype2, r2);
                    list2.add(votype2);
                }
                votype1.setChildren(list2);
                getType(votype1, r1);
                list1.add(votype1);
            }
            storeVO.setData(list1);
            storeVO.setErrmsg("成功");
            storeVO.setErrno(0);
            return storeVO;
        }catch (Exception e){
            storeVO.setErrno(1);
            storeVO.setErrmsg("失败");
            return storeVO;
        }
    }

    private void getType(RegionReadVO votype3, Region r3) {
        votype3.setCode(r3.getCode());
        votype3.setId(r3.getId());
        votype3.setName(r3.getName());
        votype3.setType(r3.getType());
    }

}
