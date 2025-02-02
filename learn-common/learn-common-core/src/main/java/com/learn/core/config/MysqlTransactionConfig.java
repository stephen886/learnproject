package com.learn.core.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @ClassName MysqlTransactionConfig
 * @Description mysql事务管理器配置
 * @Author dajie
 * @Date 2021/6/22 3:19 下午
 */

@Configuration
public class MysqlTransactionConfig {

    @Primary
    @Bean
    @ConditionalOnBean(DataSource.class)
    public PlatformTransactionManager mysqlTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }



}
