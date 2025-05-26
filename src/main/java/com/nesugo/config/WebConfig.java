package com.nesugo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 全てのエンドポイントに対してCORSを設定
                .allowedOrigins("http://localhost:8082", "http://192.168.86.150") // フロントエンドのURLを設定
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 許可するHTTPメソッドを指定
                .allowedHeaders("*") // 許可するヘッダ
                .allowCredentials(true); // クッキーや認証情報も許可
    }
}
