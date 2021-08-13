package com.lockie.shardingsphere.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig {

   /** 配置 Druid 的性能监控,配置一个管理后台的Servlet **/
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","root");
        map.put("loginPassword","root");
        /** 不写 或者为null 默认允许所有 **/
        map.put("allow","127.0.0.1");
        /*map.put("deny","192.168.1.122");*/
        bean.setInitParameters(map);
        return  bean;
    }

    /** 配置一个监控的Filter **/
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean initParam = new FilterRegistrationBean();
        initParam.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        /** 初始化不拦截请求的参数 **/
        map.put("exclusions","/**/*.css,/**/*.png,/**/*.jpg,/**/*.js,/druid/*");
        initParam.setInitParameters(map);
        /** 监控所有的请求 **/
        initParam.setUrlPatterns(Arrays.asList("/*"));
        return initParam;
    }
}
