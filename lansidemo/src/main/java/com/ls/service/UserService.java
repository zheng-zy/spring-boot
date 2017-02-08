package com.ls.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ls.mapper.UserMapper;
import com.ls.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public PageInfo<User> list(User user) {
        if (user.getPage() != null && user.getRows() != null) {
            PageHelper.startPage(user.getPage(), user.getRows());
        }
        return new PageInfo<User>(userMapper.selectAll());
    }


}
