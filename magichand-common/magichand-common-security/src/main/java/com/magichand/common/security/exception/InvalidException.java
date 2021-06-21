package com.magichand.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magichand.common.security.component.MagicHandAuth2ExceptionSerializer;


@JsonSerialize(using = MagicHandAuth2ExceptionSerializer.class)
public class InvalidException extends MagicHandAuth2Exception {

	public InvalidException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "invalid_exception";
	}

	@Override
	public int getHttpErrorCode() {
		return 426;
	}

}
