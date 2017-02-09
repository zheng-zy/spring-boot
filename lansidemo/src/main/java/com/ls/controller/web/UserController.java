package com.ls.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.common.entity.JsonResult;
import com.github.pagehelper.Page;
import com.ls.model.User;
import com.ls.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

//    @RequestMapping("/list")
//    public JSONObject list(Pageable pageable) {
//        JSONObject object = new JSONObject();
//        List<User> userList = userService.list(pageable.getPageNumber(), pageable.getPageSize());
//        object.put("rows", userList);
//        return object;
//    }

    @RequestMapping("/list")
    public JSONObject list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer rows) {
        JSONObject object = new JSONObject();
        List<User> userList = userService.list(page, rows);
        object.put("rows", userList);
        object.put("total", ((Page) userList).getTotal());
        return object;
    }

    @RequestMapping(value = "/{id}")
    public User get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public JsonResult save(@RequestBody User user) {
        userService.save(user);
        return JsonResult.SUCCESS;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public JsonResult update(@RequestBody User user) {
        userService.update(user);
        return JsonResult.SUCCESS;
    }

    @RequestMapping(value = "/delete/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        userService.delete(id);
        return JsonResult.SUCCESS;
    }


}
