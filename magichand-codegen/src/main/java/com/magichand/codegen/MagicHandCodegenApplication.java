package com.magichand.codegen;

import com.magichand.common.datasource.annotation.EnableDynamicDataSource;
import com.magichand.common.feign.annotation.EnableMagicHandFeignClients;
import com.magichand.common.security.annotation.EnableMagicHandResourceServer;
import com.magichand.common.swagger.annotation.EnableMagicHandSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 代码生成模块
 */
@EnableDynamicDataSource
@EnableMagicHandFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableMagicHandResourceServer
@EnableMagicHandSwagger2
public class MagicHandCodegenApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicHandCodegenApplication.class, args);
	}

}
