package com.magichand.common.security.annotation;

import com.magichand.common.security.component.MagicHandResourceServerAutoConfiguration;
import com.magichand.common.security.component.MagicHandSecurityBeanDefinitionRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.lang.annotation.*;

/**
 * 资源服务注解
 */
@Documented
@Inherited
@EnableResourceServer
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import({ MagicHandResourceServerAutoConfiguration.class, MagicHandSecurityBeanDefinitionRegistrar.class })
public @interface EnableMagicHandResourceServer {

}
