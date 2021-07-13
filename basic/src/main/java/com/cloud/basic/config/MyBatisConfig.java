package com.cloud.basic.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.cloud.basic.mapper")
public class MyBatisConfig {
}