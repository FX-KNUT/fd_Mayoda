package com.fx.mayodabe;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.sql.DataSource;

@Configuration
public class Config implements WebMvcConfigurer {
    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
        dataSourceBuilder.url("jdbc:mysql://mayodadb.cnsocyvopinv.ap-northeast-2.rds.amazonaws.com:58321/MayodaDB");
        dataSourceBuilder.username("admin");
        dataSourceBuilder.password("20211228");
        return dataSourceBuilder.build();
    }
}

