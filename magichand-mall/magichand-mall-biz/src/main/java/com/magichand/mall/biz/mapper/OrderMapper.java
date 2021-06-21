
package com.magichand.mall.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magichand.mall.biz.entity.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单管理
 *
 * @author wuph
 * @date 2021-04-01 13:08:06
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}
