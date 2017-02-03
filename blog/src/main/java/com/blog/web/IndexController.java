package com.blog.web;

import com.alibaba.fastjson.JSON;
import com.blog.dao.BlogDao;
import com.blog.entity.Blog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.blog.utils.Const.BLOG;
import static com.blog.utils.Const.BLOGS;

/**
 * <p>home</p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@Controller
public class IndexController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Resource
    private BlogDao blogDao;

    @RequestMapping("/")
    public String index(Model model) {
        List<Blog> blogs = (List<Blog>) blogDao.findAll();
        model.addAttribute(BLOGS, blogs);
        logger.info("index {}", JSON.toJSONString(model));
        return "index";
    }

    @RequestMapping(value = "/blog/{id}")
    public String detail(@PathVariable Integer id, Model model) {
        Blog blog = blogDao.findOne(id);
        model.addAttribute(BLOG, blog);
        logger.info("blog {}", JSON.toJSONString(model));
        return "detail";
    }


//    @RequestMapping("/freemarker")
//    public String index(Model model) {
//        model.addAttribute("user", "hello");
//        model.addAttribute("latestProduct", ImmutableBiMap.of("url", "green_mouse", "name", "green mouse"));
//        model.addAttribute("animals", ImmutableList.of("python", "java", "c++"));
//        Map<String, Object> cargo = new HashMap<String, Object>();
//        cargo.put("name", "coal");
//        cargo.put("weight", 40);
//        cargo.put("weight2", 80);
//        model.addAttribute("cargo", cargo);
////        model.addAttribute("cargo", ImmutableBiMap.of("name ", "coal", "weight", "40"));
//        logger.info(JSON.toJSONString(model));
//        return "index";
//    }

    @RequestMapping("/green_mouse")
    public String green(Map<String, Object> map) {
        map.put("time", new Date());
        return "products/green_mouse";
    }
}
