package com.magichand.npms.admin.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.magichand.npms.admin.api.dto.SysLogDTO;
import com.magichand.npms.admin.api.entity.SysLog;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 */
public interface SysLogService extends IService<SysLog> {

	/**
	 * 分页查询日志
	 * @param page
	 * @param sysLog
	 * @return
	 */
	Page getLogByPage(Page page, SysLogDTO sysLog);

}
