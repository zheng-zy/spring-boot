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

    @RequestMapping(value = "/portal/json", method = RequestMethod.POST)
    public String json() {
        return "{\n" +
                "  \"total\": 28,\n" +
                "  \"rows\": [\n" +
                "    {\n" +
                "      \"productid\": \"FI-SW-01\",\n" +
                "      \"unitcost\": 10.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 16.50,\n" +
                "      \"attr1\": \"Large\",\n" +
                "      \"itemid\": \"EST-1\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"K9-DL-01\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 18.50,\n" +
                "      \"attr1\": \"Spotted Adult Female\",\n" +
                "      \"itemid\": \"EST-10\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"RP-SN-01\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 18.50,\n" +
                "      \"attr1\": \"Venomless\",\n" +
                "      \"itemid\": \"EST-11\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"RP-SN-01\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 18.50,\n" +
                "      \"attr1\": \"Rattleless\",\n" +
                "      \"itemid\": \"EST-12\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"RP-LI-02\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 18.50,\n" +
                "      \"attr1\": \"Green Adult\",\n" +
                "      \"itemid\": \"EST-13\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"FL-DSH-01\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 58.50,\n" +
                "      \"attr1\": \"Tailless\",\n" +
                "      \"itemid\": \"EST-14\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"FL-DSH-01\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 23.50,\n" +
                "      \"attr1\": \"With tail\",\n" +
                "      \"itemid\": \"EST-15\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"FL-DLH-02\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 93.50,\n" +
                "      \"attr1\": \"Adult Female\",\n" +
                "      \"itemid\": \"EST-16\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"FL-DLH-02\",\n" +
                "      \"unitcost\": 12.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 93.50,\n" +
                "      \"attr1\": \"Adult Male\",\n" +
                "      \"itemid\": \"EST-17\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"productid\": \"AV-CB-01\",\n" +
                "      \"unitcost\": 92.00,\n" +
                "      \"status\": \"P\",\n" +
                "      \"listprice\": 193.50,\n" +
                "      \"attr1\": \"Adult Male\",\n" +
                "      \"itemid\": \"EST-18\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";
    }

}
