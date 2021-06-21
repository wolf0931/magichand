package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.SpuAttribute;
import com.magichand.mall.biz.service.SpuAttributeService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author magichand code generator
 * @date 2021-04-02 14:06:23
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/spuattribute" )
@Api(value = "spuattribute", tags = "管理")
public class SpuAttributeController {

    private final  SpuAttributeService spuAttributeService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spuAttribute 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('biz_spuattribute_get')" )
    public R getSpuAttributePage(Page page, SpuAttribute spuAttribute) {
        return R.ok(spuAttributeService.page(page, Wrappers.query(spuAttribute)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_spuattribute_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuAttributeService.getById(id));
    }

    /**
     * 新增
     * @param spuAttribute 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_spuattribute_add')" )
    public R save(@RequestBody SpuAttribute spuAttribute) {
        return R.ok(spuAttributeService.save(spuAttribute));
    }

    /**
     * 修改
     * @param spuAttribute 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_spuattribute_edit')" )
    public R updateById(@RequestBody SpuAttribute spuAttribute) {
        return R.ok(spuAttributeService.updateById(spuAttribute));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_spuattribute_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuAttributeService.removeById(id));
    }

}
