package com.magichand.mall.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magichand.mall.biz.entity.Order;
import com.magichand.mall.biz.mapper.OrderMapper;
import com.magichand.mall.biz.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单管理
 *
 * @author wuph
 * @date 2021-04-01 13:08:06
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
