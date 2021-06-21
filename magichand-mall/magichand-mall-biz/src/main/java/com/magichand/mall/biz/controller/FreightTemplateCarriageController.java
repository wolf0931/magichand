package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.FreightTemplateCarriage;
import com.magichand.mall.biz.service.FreightTemplateCarriageService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 运费模板价格
 *
 * @author magichand code generator
 * @date 2021-04-02 14:15:32
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/freighttemplatecarriage" )
@Api(value = "freighttemplatecarriage", tags = "运费模板价格管理")
public class FreightTemplateCarriageController {

	private final  FreightTemplateCarriageService freightTemplateCarriageService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param freightTemplateCarriage 运费模板价格
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplatecarriage_get')" )
	public R getFreightTemplateCarriagePage(Page page, FreightTemplateCarriage freightTemplateCarriage) {
		return R.ok(freightTemplateCarriageService.page(page, Wrappers.query(freightTemplateCarriage)));
	}


	/**
	 * 通过id查询运费模板价格
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplatecarriage_get')" )
	public R getById(@PathVariable("id" ) Long id) {
		return R.ok(freightTemplateCarriageService.getById(id));
	}

	/**
	 * 新增运费模板价格
	 * @param freightTemplateCarriage 运费模板价格
	 * @return R
	 */
	@ApiOperation(value = "新增运费模板价格", notes = "新增运费模板价格")
	@SysLog("新增运费模板价格" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('biz_freighttemplatecarriage_add')" )
	public R save(@RequestBody FreightTemplateCarriage freightTemplateCarriage) {
		return R.ok(freightTemplateCarriageService.save(freightTemplateCarriage));
	}

	/**
	 * 修改运费模板价格
	 * @param freightTemplateCarriage 运费模板价格
	 * @return R
	 */
	@ApiOperation(value = "修改运费模板价格", notes = "修改运费模板价格")
	@SysLog("修改运费模板价格" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('biz_freighttemplatecarriage_edit')" )
	public R updateById(@RequestBody FreightTemplateCarriage freightTemplateCarriage) {
		return R.ok(freightTemplateCarriageService.updateById(freightTemplateCarriage));
	}

	/**
	 * 通过id删除运费模板价格
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除运费模板价格", notes = "通过id删除运费模板价格")
	@SysLog("通过id删除运费模板价格" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_freighttemplatecarriage_del')" )
	public R removeById(@PathVariable Long id) {
		return R.ok(freightTemplateCarriageService.removeById(id));
	}

}
