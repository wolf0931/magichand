package com.magichand.mall.biz;

import com.magichand.common.feign.annotation.EnableMagicHandFeignClients;
import com.magichand.common.security.annotation.EnableMagicHandResourceServer;
import com.magichand.common.swagger.annotation.EnableMagicHandSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableMagicHandFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@EnableMagicHandResourceServer
@EnableMagicHandSwagger2
public class MagicHandMallAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicHandMallAdminApplication.class, args);
	}

}
