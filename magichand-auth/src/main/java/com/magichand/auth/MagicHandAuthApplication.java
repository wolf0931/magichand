package com.magichand.auth;

import com.magichand.common.feign.annotation.EnableMagicHandFeignClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 认证授权中心
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableMagicHandFeignClients
public class MagicHandAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicHandAuthApplication.class, args);
	}

}
