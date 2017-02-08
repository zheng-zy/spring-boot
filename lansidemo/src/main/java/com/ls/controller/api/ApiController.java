package com.ls.controller.api;

import com.common.entity.JsonResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/6.
 */
@RestController
public class ApiController {

    @RequestMapping("/test")
    public JsonResult test() {
        return JsonResult.SUCCESS;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public JsonResult hello(@RequestBody Map<String, Object> params) throws Exception {
        String name = (String) params.get("name");
        if (name.equals("haha")) throw new Exception("this is a exception!");
        return new JsonResult(name == null ? "default" : name);
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public JsonResult hello(@PathVariable String name) {
        return new JsonResult(name == null ? "default" : name);
    }

}
