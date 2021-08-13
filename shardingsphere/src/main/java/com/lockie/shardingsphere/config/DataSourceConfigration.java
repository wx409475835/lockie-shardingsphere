/* Copyright © 2020 pyacm.com and/or its affiliates. All rights reserved. */
package com.lockie.shardingsphere.config;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.datasource.MasterSlaveDataSource;
import org.apache.shardingsphere.shardingjdbc.spring.boot.SpringBootConfiguration;
import org.apache.shardingsphere.spring.boot.datasource.DataSourcePropertiesSetterHolder;
import org.apache.shardingsphere.spring.boot.util.DataSourceUtil;
import org.apache.shardingsphere.spring.boot.util.PropertyUtil;
import org.apache.shardingsphere.underlying.common.config.inline.InlineExpressionParser;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

/**
 * @author lvhaoguang
 * @date 2021-08-03 16:10
 */
@Slf4j
@Configuration
@AutoConfigureBefore(MybatisAutoConfiguration.class)
@AutoConfigureAfter(SpringBootConfiguration.class)
@ConditionalOnProperty(prefix = "spring.shardingsphere",name = "enabled",havingValue = "true")
public class DataSourceConfigration {

    @Autowired
    private DataSource masterSlaveDataSource;

    @Bean
    @Primary
    public DataSource dataSource(){
        return masterSlaveDataSource;
    }

//    private final Environment environment;
//
//    public DataSourceConfigration(Environment environment) {
//        this.environment = environment;
//    }
//
//    /** 默认加载master数据源 **/
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        String prefix = "spring.shardingsphere.datasource.";
//        String each = this.getDataSourceNames(prefix).get(0);
//        try {
//            return this.getDataSource(prefix, each);
//        } catch (final ReflectiveOperationException ex) {
//            log.error("Can't find datasource type!", ex);
//        }
//        return null;
//    }
//
//    private List<String> getDataSourceNames(final String prefix) {
//        StandardEnvironment standardEnv = (StandardEnvironment) this.environment;
//        standardEnv.setIgnoreUnresolvableNestedPlaceholders(true);
//        return null == standardEnv.getProperty(prefix + "name") ?
//            new InlineExpressionParser(standardEnv.getProperty(prefix + "names")).splitAndEvaluate()
//            : Collections.singletonList(standardEnv.getProperty(prefix + "name"));
//    }
//
//    @SuppressWarnings("unchecked")
//    private DataSource getDataSource(final String prefix, final String dataSourceName) throws ReflectiveOperationException {
//
//        Map dataSourceProps =  PropertyUtil.handle(this.environment, prefix + dataSourceName.trim(),
//            Map.class);
//        Preconditions.checkState(!dataSourceProps.isEmpty(), "Wrong datasource properties!");
//        DataSource result = DataSourceUtil.getDataSource(dataSourceProps.get("type").toString(), dataSourceProps);
//        /** 去掉校验 **/
//        DataSourcePropertiesSetterHolder.getDataSourcePropertiesSetterByType(dataSourceProps.get("type").toString())
//            .ifPresent(dataSourcePropertiesSetter -> dataSourcePropertiesSetter.propertiesSet(this.environment, prefix, dataSourceName, result));
//        return result;
//    }
}
