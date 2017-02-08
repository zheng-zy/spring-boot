package com.ls.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>通用页面跳转</p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@Controller
public class PageController {

    @RequestMapping("/page/{view}")
    public String page(@PathVariable String view) {
        return view;
    }

}
