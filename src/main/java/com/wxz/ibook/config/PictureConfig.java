package com.wxz.ibook.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Wangxingze
 * @date 2019-06-18 17:58
 */
@Configuration
public class PictureConfig implements WebMvcConfigurer {

      @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/user/**").addResourceLocations("file:/home/shop/src/main/resources/static/user/");
    }


}
