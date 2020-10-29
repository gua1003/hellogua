package com.usian.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;


@Configuration
public class JdbcConfiguration {


    /*@Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource= new DruidDataSource();
        return  druidDataSource;
    }*/
}
