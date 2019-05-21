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
 * @date:2019/4/12 16:46
 * @Description:
 */
@Configuration
@MapperScan(basePackages = BiDataSourceConfig.PACKAGE,sqlSessionFactoryRef = "biSqlSessionFactory")
public class BiDataSourceConfig {

    // mysqldao扫描路径
    static final String PACKAGE = "com.zhzh.bidao";
    // mybatis mapper扫描路径
    static final String MAPPER_LOCATION = "classpath:mapper/bi/*.xml";
    @Bean(name = "biDataSource")
    @ConfigurationProperties("spring.datasource.druid.zhbi")
    public DataSource biDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean(name = "biDataSourceTransactionManager")
    public DataSourceTransactionManager biDataSourceTransactionManager(){
        return new DataSourceTransactionManager(biDataSource());
    }

    @Bean("biSqlSessionFactory")
    public SqlSessionFactory biSqlSessionFactory(@Qualifier("biDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setMapperLocations
                (new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }
}
