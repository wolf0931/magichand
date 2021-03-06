package com.magichand.gateway.config;

import com.magichand.gateway.filter.PasswordDecoderFilter;
import com.magichand.gateway.filter.ValidateCodeGatewayFilter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 * 网关配置文件
 */
@Data
@Component
@RefreshScope
@ConfigurationProperties("gateway")
public class GatewayConfigProperties {

	/**
	 * 网关解密登录前端密码 秘钥 {@link PasswordDecoderFilter}
	 */
	public String encodeKey;

	/**
	 * 网关不需要校验验证码的客户端 {@link ValidateCodeGatewayFilter}
	 */
	public List<String> ignoreClients;

}