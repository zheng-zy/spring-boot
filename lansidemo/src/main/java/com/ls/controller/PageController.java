package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>通用页面跳转</p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@Controller
public class PageController {

    @RequestMapping(value = "/page/{view}", method = RequestMethod.GET)
    public String page(@PathVariable String view) {
        return view;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "user/list";
    }


}
