package com.luohai.myblogger.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * luohai
 * 解决浏览器禁止加载本地文件的问题
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/FileImages/**").addResourceLocations("file:C:/project/myBloger/BlogsFile/BlogsArticleImage/");
    }


}
