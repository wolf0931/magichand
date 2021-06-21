package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.GroupShop;
import com.magichand.mall.biz.service.GroupShopService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 团购商品
 *
 * @author magichand code generator
 * @date 2021-04-02 14:09:50
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/groupshop" )
@Api(value = "groupshop", tags = "团购商品管理")
public class GroupShopController {

	private final  GroupShopService groupShopService;

	/**
	 * 分页查询
	 * @param page 分页对象
	 * @param groupShop 团购商品
	 * @return
	 */
	@ApiOperation(value = "分页查询", notes = "分页查询")
	@GetMapping("/page" )
	@PreAuthorize("@pms.hasPermission('biz_groupshop_get')" )
	public R getGroupShopPage(Page page, GroupShop groupShop) {
		return R.ok(groupShopService.page(page, Wrappers.query(groupShop)));
	}


	/**
	 * 通过id查询团购商品
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id查询", notes = "通过id查询")
	@GetMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_groupshop_get')" )
	public R getById(@PathVariable("id" ) Long id) {
		return R.ok(groupShopService.getById(id));
	}

	/**
	 * 新增团购商品
	 * @param groupShop 团购商品
	 * @return R
	 */
	@ApiOperation(value = "新增团购商品", notes = "新增团购商品")
	@SysLog("新增团购商品" )
	@PostMapping
	@PreAuthorize("@pms.hasPermission('biz_groupshop_add')" )
	public R save(@RequestBody GroupShop groupShop) {
		return R.ok(groupShopService.save(groupShop));
	}

	/**
	 * 修改团购商品
	 * @param groupShop 团购商品
	 * @return R
	 */
	@ApiOperation(value = "修改团购商品", notes = "修改团购商品")
	@SysLog("修改团购商品" )
	@PutMapping
	@PreAuthorize("@pms.hasPermission('biz_groupshop_edit')" )
	public R updateById(@RequestBody GroupShop groupShop) {
		return R.ok(groupShopService.updateById(groupShop));
	}

	/**
	 * 通过id删除团购商品
	 * @param id id
	 * @return R
	 */
	@ApiOperation(value = "通过id删除团购商品", notes = "通过id删除团购商品")
	@SysLog("通过id删除团购商品" )
	@DeleteMapping("/{id}" )
	@PreAuthorize("@pms.hasPermission('biz_groupshop_del')" )
	public R removeById(@PathVariable Long id) {
		return R.ok(groupShopService.removeById(id));
	}

}
