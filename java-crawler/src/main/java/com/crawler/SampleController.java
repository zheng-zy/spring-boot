package com.crawler;

import com.crawler.service.HelloWorldService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@SpringBootApplication
public class SampleController {

    @Resource
    private HelloWorldService helloWorldService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return helloWorldService.getHelloMessage();
    }
}