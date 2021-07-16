package com.ggoreb.practice.config;

import com.ggoreb.practice.interceptor.SignInInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    SignInInterceptor signInInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> path = new ArrayList<>();
        registry.addInterceptor(signInInterceptor).addPathPatterns("/**/create");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
