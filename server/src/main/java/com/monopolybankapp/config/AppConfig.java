package com.monopolybankapp.config;

import com.monopolybankapp.security.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private JwtInterceptor jwtInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO: h2 only in dev
        registry.addInterceptor(jwtInterceptor)
                .excludePathPatterns("/rest/login","/error","/rest/users/create","/h2");
    }
}
