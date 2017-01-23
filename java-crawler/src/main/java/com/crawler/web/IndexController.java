package com.crawler.web;

import com.crawler.constant.JsonResult;
import com.crawler.service.HelloWorldService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@RestController
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    @ResponseBody
    public String home() {
        logger.info("hello world");
        return helloWorldService.getHelloMessage();
    }

    @RequestMapping("/start")
    @ResponseBody
    public JsonResult start() {
        return JsonResult.SUCCESS;
    }


}
