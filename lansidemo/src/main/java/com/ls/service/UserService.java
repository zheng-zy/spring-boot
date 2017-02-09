package com.ls.service;

import com.ls.mapper.UserMapper;
import com.ls.model.User;
import com.ls.util.BaseMapper;
import com.ls.util.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@Service
public class UserService extends BaseServiceImpl<User, Integer> {

    @Resource
    private UserMapper userMapper;

    @Override
    public BaseMapper getMapper() {
        return userMapper;
    }
}
