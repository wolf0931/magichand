package com.magichand.npms.admin.api.feign.factory;

import com.magichand.npms.admin.api.feign.RemoteUserService;
import com.magichand.npms.admin.api.feign.fallback.RemoteUserServiceFallbackImpl;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;


@Component
public class RemoteUserServiceFallbackFactory implements FallbackFactory<RemoteUserService> {

	@Override
	public RemoteUserService create(Throwable throwable) {
		RemoteUserServiceFallbackImpl remoteUserServiceFallback = new RemoteUserServiceFallbackImpl();
		remoteUserServiceFallback.setCause(throwable);
		return remoteUserServiceFallback;
	}

}
