package com.ls;

import com.ls.util.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/8.
 */
@Controller
@EnableWebMvc
@SpringBootApplication
//@ServletComponentScan
@MapperScan(basePackages = "com.ls.mapper", markerInterface = MyMapper.class)
public class LsApplication {
    public static void main(String[] args) {
        SpringApplication.run(LsApplication.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "redirect:countries";
    }
}
