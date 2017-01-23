package com.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * <p>home</p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String view(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "hello");
        return "index";
    }

}
