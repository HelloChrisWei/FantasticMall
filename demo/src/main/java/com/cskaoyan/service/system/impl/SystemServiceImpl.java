package com.cskaoyan.service.system.impl;

import com.cskaoyan.bean.MallSystem;
import com.cskaoyan.bean.System;
import com.cskaoyan.mapper.MallSystemMapper;
import com.cskaoyan.mapper.SystemMapper;
import com.cskaoyan.service.system.SystemService;
import com.cskaoyan.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class SystemServiceImpl implements SystemService {
    @Resource
    MallSystemMapper mapper;
    @Override
    public List<MallSystem> selectMallSystemByPrefix(String prefix) {
        prefix = "%" + prefix + "%";
        List<MallSystem> mallSystems = mapper.selectMallSystemByMall(prefix);
        return mallSystems;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ)
    public boolean updateMallSystem(Map<String,String> map) {
        for (String keyName : map.keySet()) {
            MallSystem system = new MallSystem();
            system.setKeyName(keyName);
            system.setKeyValue(map.get(keyName));
            system.setUpdateTime(new Date());
            int update = mapper.updateMallSystem(system);
            if (update != 1){
                return false;
            }
        }
        return true;

    }


}
