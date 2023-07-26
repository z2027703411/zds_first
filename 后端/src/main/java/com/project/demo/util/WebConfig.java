package com.project.demo.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//解决跨域问题的类
@Configuration//让其成为全局配置类的注意
public class WebConfig implements WebMvcConfigurer {
    //ctrl+O

    //这个方法专门解决跨域问题
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//任何访问路径都运许跨域
                .allowedOrigins("Http://localhost:8080","null")//运许跨域的来源
                .allowedMethods("GET","POST","PUT","OPTIONS","DELETE")//运许跨域的方法
                .allowCredentials(true)//运许是否携带一些信息
                .maxAge(3600);//设置最大响应时间
    }
}
