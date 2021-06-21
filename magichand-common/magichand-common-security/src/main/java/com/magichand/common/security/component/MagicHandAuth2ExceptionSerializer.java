package com.magichand.common.security.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.magichand.common.core.constant.CommonConstants;
import com.magichand.common.security.exception.MagicHandAuth2Exception;
import lombok.SneakyThrows;

/**
 *  异常格式化
 */
public class MagicHandAuth2ExceptionSerializer extends StdSerializer<MagicHandAuth2Exception> {

	public MagicHandAuth2ExceptionSerializer() {
		super(MagicHandAuth2Exception.class);
	}

	@Override
	@SneakyThrows
	public void serialize(MagicHandAuth2Exception value, JsonGenerator gen, SerializerProvider provider) {
		gen.writeStartObject();
		gen.writeObjectField("code", CommonConstants.FAIL);
		gen.writeStringField("msg", value.getMessage());
		gen.writeStringField("data", value.getErrorCode());
		gen.writeEndObject();
	}

}
