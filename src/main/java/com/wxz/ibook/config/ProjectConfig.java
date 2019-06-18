package com.wxz.ibook.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置项目路径等
 * @author Wangxingze
 * @date 2019-06-10 09:01
 */
@Data
@Component
//projecturl必须小写
@ConfigurationProperties(prefix = "projecturl")
public class ProjectConfig {
    private  String ibook;
    private String bookImageSavePath;
}
