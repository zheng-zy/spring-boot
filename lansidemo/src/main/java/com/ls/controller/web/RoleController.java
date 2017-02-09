package com.ls.controller.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ls.model.Role;
import com.ls.service.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public void test() {
        Role role = roleService.getById(1);
        System.out.println("JSON.toJSONString(role) = " + JSON.toJSONString(role));
    }

    @RequestMapping(value = "list", method = RequestMethod.POST)
    public JSONObject list() {
        return new JSONObject();
    }

}
