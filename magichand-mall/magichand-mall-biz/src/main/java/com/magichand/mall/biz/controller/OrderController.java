package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.entity.Order;
import com.magichand.mall.biz.service.OrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


/**
 * 订单管理
 *
 * @author wuph
 * @date 2021-04-01 13:08:06
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/order" )
@Api(value = "order", tags = "订单管理管理")
public class OrderController {

    private final  OrderService orderService;

    /**
     * 分页查询
     * @param page 分页对象
     * @param order 订单管理
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('biz_order_get')" )
    public R getOrderPage(Page page, Order order) {
        return R.ok(orderService.page(page, Wrappers.query(order)));
    }


    /**
     * 通过id查询订单管理
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_order_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(orderService.getById(id));
    }

    /**
     * 新增订单管理
     * @param order 订单管理
     * @return R
     */
    @ApiOperation(value = "新增订单管理", notes = "新增订单管理")
    @SysLog("新增订单管理" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_order_add')" )
    public R save(@RequestBody Order order) {
        return R.ok(orderService.save(order));
    }

    /**
     * 修改订单管理
     * @param order 订单管理
     * @return R
     */
    @ApiOperation(value = "修改订单管理", notes = "修改订单管理")
    @SysLog("修改订单管理" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_order_edit')" )
    public R updateById(@RequestBody Order order) {
        return R.ok(orderService.updateById(order));
    }

    /**
     * 通过id删除订单管理
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除订单管理", notes = "通过id删除订单管理")
    @SysLog("通过id删除订单管理" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_order_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(orderService.removeById(id));
    }

}
