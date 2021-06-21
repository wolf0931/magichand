package com.magichand.mall.biz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 团购商品
 *
 * @author magichand code generator
 * @date 2021-04-02 14:09:50
 */
@Data
@TableName("group_shop")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "团购商品")
public class GroupShop extends Model<GroupShop> {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	@ApiModelProperty(value="")
	private Long id;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Long spuId;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer minPrice;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer maxPrice;
	/**
	 * 团购开始时间
	 */
	@ApiModelProperty(value="团购开始时间")
	private LocalDateTime gmtStart;
	/**
	 * 团购结束时间
	 */
	@ApiModelProperty(value="团购结束时间")
	private LocalDateTime gmtEnd;
	/**
	 * 团购基础人数
	 */
	@ApiModelProperty(value="团购基础人数")
	private Integer minimumNumber;
	/**
	 * 团购已经购买人数
	 */
	@ApiModelProperty(value="团购已经购买人数")
	private Integer alreadyBuyNumber;
	/**
	 * 团购结束时购买人数未达到基础人数,是否自动退款
	 */
	@ApiModelProperty(value="团购结束时购买人数未达到基础人数,是否自动退款")
	private Integer automaticRefund;
	/**
	 * 判断团购商品是否在活动期间
	 */
	@ApiModelProperty(value="判断团购商品是否在活动期间")
	private Integer status;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private LocalDateTime gmtCreate;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private LocalDateTime gmtUpdate;
}
