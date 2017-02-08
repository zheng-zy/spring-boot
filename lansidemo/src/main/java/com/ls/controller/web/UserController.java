package com.ls.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.ls.model.User;
import com.ls.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public JSONObject list() {
        JSONObject object = new JSONObject();
        User user = new User();
        PageInfo<User> userPageInfo = userService.list(user);
        object.put("rows", userPageInfo.getList());
        object.put("total", userPageInfo.getTotal());
        return object;
    }

}
