package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.dto.server.GoodsDTOServer;
import com.magichand.mall.biz.entity.Good;
import com.magichand.mall.biz.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * 商品信息
 *
 * @author magichand code generator
 * @date 2021-04-02 10:28:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/goods" )
@Api(value = "goods", tags = "商品信息管理")
public class GoodController {

    private final GoodService goodService;

    private final GoodsDTOServer goodsDTOServer;

    /**
     * 分页查询
     * @param page 分页对象
     * @param good 前端商品信息
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    public R getGoodsPage(Page page, Good good) {
    	return R.ok(goodsDTOServer.list(page, good));
    }


    /**
     * 通过id查询商品信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(goodService.getById(id));
    }

    /**
     * 新增商品信息
     * @param good 商品信息
     * @return R
     */
    @ApiOperation(value = "新增商品信息", notes = "新增商品信息")
    @SysLog("新增商品信息" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_good_add')" )
    public R save(@RequestBody Good good) {
        return R.ok(goodService.save(good));
    }

    /**
     * 修改商品信息
     * @param good 商品信息
     * @return R
     */
    @ApiOperation(value = "修改商品信息", notes = "修改商品信息")
    @SysLog("修改商品信息" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_good_edit')" )
    public R updateById(@RequestBody Good good) {
        return R.ok(goodService.updateById(good));
    }

    /**
     * 通过id删除商品信息
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品信息", notes = "通过id删除商品信息")
    @SysLog("通过id删除商品信息" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_good_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(goodService.removeById(id));
    }

}
