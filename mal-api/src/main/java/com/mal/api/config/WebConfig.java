package com.mal.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/mal_demo/**") // すべてのAPIエンドポイントにCORS設定を適用
                .allowedOrigins("http://localhost:4200") // フロントエンドのオリジンを許可
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 許可するHTTPメソッド
                .allowedHeaders("*") // すべてのヘッダーを許可
                .allowCredentials(true); // 認証情報（クッキーなど）を許可
    }

}
