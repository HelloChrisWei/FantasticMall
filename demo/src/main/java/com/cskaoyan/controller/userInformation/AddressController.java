package com.cskaoyan.controller.userInformation;

import com.cskaoyan.service.userInformaitonService.AddressService;
import com.cskaoyan.vo.ReadVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddressController {
    @Autowired
    AddressService addressService;

    @RequestMapping("/address/list")
    @ResponseBody
    public ReadVO selectAddressByContidion(int page,int limit,Integer userId,String name){
        return addressService.seleceAddressByCondition(page, limit, userId, name);
    }
}
