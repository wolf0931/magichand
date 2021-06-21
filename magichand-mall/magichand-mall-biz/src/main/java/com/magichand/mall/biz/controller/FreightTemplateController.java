package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.FreightTemplate;
import com.magichand.mall.biz.service.FreightTemplateService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 运费模板
 *
 * @author magichand code generator
 * @date 2021-04-02 14:12:56
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/freighttemplate" )
@Api(value = "freighttemplate", tags = "运费模板管理")
public class FreightTemplateController {

	private final  FreightTemplateService freightTemplateService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param freightTemplate 运费模板
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplate_get')" )
	public R getFreightTemplatePage(Page page, FreightTemplate freightTemplate) {
		return R.ok(freightTemplateService.page(page, Wrappers.query(freightTemplate)));
	}


	/**
	 * 通过id查询运费模板
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplate_get')" )
	public R getById(@PathVariable("id" ) Long id) {
		return R.ok(freightTemplateService.getById(id));
	}

	/**
	 * 新增运费模板
	 * @param freightTemplate 运费模板
	 * @return R
	 */
	@ApiOperation(value = "新增运费模板", notes = "新增运费模板")
	@SysLog("新增运费模板" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('biz_freighttemplate_add')" )
	public R save(@RequestBody FreightTemplate freightTemplate) {
		return R.ok(freightTemplateService.save(freightTemplate));
	}

	/**
	 * 修改运费模板
	 * @param freightTemplate 运费模板
	 * @return R
	 */
	@ApiOperation(value = "修改运费模板", notes = "修改运费模板")
	@SysLog("修改运费模板" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('biz_freighttemplate_edit')" )
	public R updateById(@RequestBody FreightTemplate freightTemplate) {
		return R.ok(freightTemplateService.updateById(freightTemplate));
	}

	/**
	 * 通过id删除运费模板
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除运费模板", notes = "通过id删除运费模板")
	@SysLog("通过id删除运费模板" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplate_del')" )
	public R removeById(@PathVariable Long id) {
		return R.ok(freightTemplateService.removeById(id));
	}

}
