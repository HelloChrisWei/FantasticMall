package com.cskaoyan.service.system;

import com.cskaoyan.bean.MallSystem;



import java.util.List;
import java.util.Map;

public interface SystemService {
    List<MallSystem> selectMallSystemByPrefix(String prefix);
    boolean updateMallSystem(Map<String,String> map);
}
