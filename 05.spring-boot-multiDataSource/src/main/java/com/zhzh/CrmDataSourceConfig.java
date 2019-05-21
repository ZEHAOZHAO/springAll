package com.zhzh;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @Author: jason.zhao
 * @date:2019/4/12 17:01
 * @Description:
 */
@Configuration
@MapperScan(basePackages = CrmDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "crmDataSourceFactory")
public class CrmDataSourceConfig {
    // mysqldao扫描路径
    static final String PACKAGE = "com.zhzh.crmdao";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/crm/*.xml";

    @Primary
    @Bean("crmDataSource")
    @ConfigurationProperties("spring.datasource.druid.zhCrm")
    public DataSource crmDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
    @Primary
    @Bean("crmDataSourceTransactionManager")
    public DataSourceTransactionManager crmDataSourceTransactionManager(){
        return new DataSourceTransactionManager(crmDataSource());
    }

    @Primary
    @Bean("crmDataSourceFactory")
    public SqlSessionFactory crmDataSourceFactory(@Qualifier("crmDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
