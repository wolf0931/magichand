package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.Spu;
import com.magichand.mall.biz.service.SpuService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 
 *
 * @author wuph
 * @date 2021-04-01 11:29:24
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/spu" )
@Api(value = "spu", tags = "管理")
public class SpuController {

    private final  SpuService spuService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param spu 
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('biz_spu_get')" )
    public R getSpuPage(Page page, Spu spu) {
        return R.ok(spuService.page(page, Wrappers.query(spu)));
    }


    /**
     * 通过id查询
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_spu_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(spuService.getById(id));
    }

    /**
     * 新增
     * @param spu 
     * @return R
     */
    @ApiOperation(value = "新增", notes = "新增")
    @SysLog("新增" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_spu_add')" )
    public R save(@RequestBody Spu spu) {
        return R.ok(spuService.save(spu));
    }

    /**
     * 修改
     * @param spu 
     * @return R
     */
    @ApiOperation(value = "修改", notes = "修改")
    @SysLog("修改" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_spu_edit')" )
    public R updateById(@RequestBody Spu spu) {
        return R.ok(spuService.updateById(spu));
    }

    /**
     * 通过id删除
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除", notes = "通过id删除")
    @SysLog("通过id删除" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_spu_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(spuService.removeById(id));
    }

}
