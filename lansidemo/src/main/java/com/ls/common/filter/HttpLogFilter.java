package com.ls.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>请求记录</p>
 * Created by zhezhiyong@163.com on 2017/2/7.
 */
//@WebFilter(filterName = "httpFilter", urlPatterns = "/*")
public class HttpLogFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        ByteHttpServletRequestWrapper requestWrapper;
        //碰到这个URL直接跳过过滤
        Assert.notNull(request, "request must not null!");
        String uri = request.getRequestURI();
        if (uri.startsWith("/druid/") || uri.startsWith("/static/") || uri.startsWith("/favicon")) {
            chain.doFilter(request, response);
            return;
        }
        requestWrapper = new ByteHttpServletRequestWrapper(request);
        ResponseWrapper responseWrapper = new ResponseWrapper(response);
        try {
            chain.doFilter(requestWrapper, responseWrapper);
            if (!response.isCommitted()) {
                ServletOutputStream outputStream = response.getOutputStream();
                byte[] responseData = responseWrapper.getBytes();
                if (responseData != null && responseData.length > 0) {
                    outputStream.write(responseData);
                    outputStream.flush();
                    outputStream.close();
                }
                // else{} 什么都不做,因为会重定定向到别的视图，如404视图，不可以现在关闭
            }
        } catch (Exception e) {
            logger.error("url: {}, result msg: {}", requestWrapper.getRequestURL(), e.getMessage());
        } finally {
            logger.info("url: {}, req: {}, resp: {}", requestWrapper.getRequestURL(), requestWrapper.getResult(), responseWrapper.getResult());
        }
    }


}
