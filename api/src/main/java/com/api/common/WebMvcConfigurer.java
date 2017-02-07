package com.api.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 添加拦截器
 *
 * @author zheng-zy
 */
@Configuration
@SuppressWarnings("unused")
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new StopWatchHandlerInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
