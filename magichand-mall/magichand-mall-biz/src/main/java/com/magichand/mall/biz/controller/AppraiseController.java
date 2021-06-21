package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.Appraise;
import com.magichand.mall.biz.service.AppraiseService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 评价商品

 *
 * @author wuph
 * @date 2021-04-01 13:12:03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appraise" )
@Api(value = "appraise", tags = "评价商品管理")
public class AppraiseController {

    private final  AppraiseService appraiseService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param appraise 评价商品

     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('biz_appraise_get')" )
    public R getAppraisePage(Page page, Appraise appraise) {
        return R.ok(appraiseService.page(page, Wrappers.query(appraise)));
    }


    /**
     * 通过id查询评价商品

     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_appraise_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(appraiseService.getById(id));
    }

    /**
     * 新增评价商品

     * @param appraise 评价商品

     * @return R
     */
    @ApiOperation(value = "新增评价商品 ", notes = "新增评价商品")
    @SysLog("新增评价商品 " )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_appraise_add')" )
    public R save(@RequestBody Appraise appraise) {
        return R.ok(appraiseService.save(appraise));
    }

    /**
     * 修改评价商品

     * @param appraise 评价商品

     * @return R
     */
    @ApiOperation(value = "修改评价商品 ", notes = "修改评价商品 ")
    @SysLog("修改评价商品 " )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_appraise_edit')" )
    public R updateById(@RequestBody Appraise appraise) {
        return R.ok(appraiseService.updateById(appraise));
    }

    /**
     * 通过id删除评价商品

     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除评价商品 ", notes = "通过id删除评价商品 ")
    @SysLog("通过id删除评价商品 " )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_appraise_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(appraiseService.removeById(id));
    }

}
