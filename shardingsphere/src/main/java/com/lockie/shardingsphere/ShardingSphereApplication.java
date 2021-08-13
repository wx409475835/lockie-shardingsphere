package com.lockie.shardingsphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 扫描maper **/
@SpringBootApplication
@MapperScan("com.lockie.shardingsphere.dao")
public class ShardingSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingSphereApplication.class, args);
	}

}
