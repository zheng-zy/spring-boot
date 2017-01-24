package com.blog.web;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>home</p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", "hello");
        model.addAttribute("latestProduct", ImmutableBiMap.of("url", "green_mouse", "name", "green mouse"));
        model.addAttribute("animals", ImmutableList.of("python", "java", "c++"));
        Map<String, Object> cargo = new HashMap<String, Object>();
        cargo.put("name", "coal");
        cargo.put("weight", 40);
        cargo.put("weight2", 80);
        model.addAttribute("cargo", cargo);
//        model.addAttribute("cargo", ImmutableBiMap.of("name ", "coal", "weight", "40"));
        logger.info(JSON.toJSONString(model));
        return "index";
    }

    @RequestMapping("/green_mouse")
    public String green(Map<String, Object> map) {
        map.put("time", new Date());
        return "products/green_mouse";
    }
}
