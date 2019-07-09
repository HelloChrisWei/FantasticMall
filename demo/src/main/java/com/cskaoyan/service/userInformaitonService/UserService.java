package com.cskaoyan.service.userInformaitonService;


import com.cskaoyan.bean.User;
import com.cskaoyan.mapper.UserMapper;
import com.cskaoyan.vo.ReadVO;
import com.cskaoyan.vo.SingleReadVO;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {

    ReadVO selectUser(int page,int limit,String username,String mobile);
}
