package com.magichand.gateway;

import com.magichand.common.swagger.annotation.EnableMagicHandSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * 网关应用
 */
@EnableMagicHandSwagger2
@SpringCloudApplication
public class MagicHandGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(MagicHandGatewayApplication.class, args);
	}

}
