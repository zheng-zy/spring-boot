package com.crawler.constant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>json返回值</p>
 * Created by zhezhiyong@163.com on 2017/1/23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult {

    public static final JsonResult SUCCESS = new JsonResult(true, "", null);
    public static final JsonResult FAIL = new JsonResult(false, "", null);

    private boolean success;
    private String msg;
    private Object data;

}
