package com.magichand.npms.admin;

import com.magichand.common.feign.annotation.EnableMagicHandFeignClients;
import com.magichand.common.security.annotation.EnableMagicHandResourceServer;
import com.magichand.common.swagger.annotation.EnableMagicHandSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户统一管理系统
 */
@EnableMagicHandSwagger2
@EnableMagicHandResourceServer
@EnableMagicHandFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MagicHandAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicHandAdminApplication.class, args);
	}

}
