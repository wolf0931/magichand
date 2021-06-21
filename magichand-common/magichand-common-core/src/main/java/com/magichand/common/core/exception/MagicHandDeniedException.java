package com.magichand.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * 403 授权拒绝
 */
@NoArgsConstructor
public class MagicHandDeniedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MagicHandDeniedException(String message) {
		super(message);
	}

	public MagicHandDeniedException(Throwable cause) {
		super(cause);
	}

	public MagicHandDeniedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MagicHandDeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
