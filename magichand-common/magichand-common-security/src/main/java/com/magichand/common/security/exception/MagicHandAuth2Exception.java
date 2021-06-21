package com.magichand.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magichand.common.security.component.MagicHandAuth2ExceptionSerializer;
import lombok.Getter;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

@JsonSerialize(using = MagicHandAuth2ExceptionSerializer.class)
public class MagicHandAuth2Exception extends OAuth2Exception {

	@Getter
	private String errorCode;

	public MagicHandAuth2Exception(String msg) {
		super(msg);
	}

	public MagicHandAuth2Exception(String msg, String errorCode) {
		super(msg);
		this.errorCode = errorCode;
	}

}
