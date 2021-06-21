package com.magichand.common.log.event;

import com.magichand.npms.admin.api.entity.SysLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author 系统日志事件
 */
public class SysLogEvent extends ApplicationEvent {

	public SysLogEvent(SysLog source) {
		super(source);
	}

}
