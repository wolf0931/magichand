package com.magichand.common.security.exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.magichand.common.security.component.MagicHandAuth2ExceptionSerializer;
import org.springframework.http.HttpStatus;


@JsonSerialize(using = MagicHandAuth2ExceptionSerializer.class)
public class ServerErrorException extends MagicHandAuth2Exception {

	public ServerErrorException(String msg, Throwable t) {
		super(msg);
	}

	@Override
	public String getOAuth2ErrorCode() {
		return "server_error";
	}

	@Override
	public int getHttpErrorCode() {
		return HttpStatus.INTERNAL_SERVER_ERROR.value();
	}

}
