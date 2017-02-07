package com.api.exception;

import com.common.entity.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/6.
 */
//@ControllerAdvice(annotations=RestController.class)
//@ControllerAdvice(basePackages={"com.xxx","com.ooo"})
@ControllerAdvice
@SuppressWarnings("unused")
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());

    //    @ExceptionHandler(RuntimeException.class)
    //    @ExceptionHandler(value={RuntimeException.class,MyRuntimeException.class})
    @ExceptionHandler//处理所有异常
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public JsonResult exceptionHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setMsg(e.getMessage());
        logger.error("request: {}, response: {}", request.getRequestURL(), result);
        return result;
    }

}
