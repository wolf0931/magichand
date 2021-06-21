package com.magichand.mall.biz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 订单管理
 *
 * @author wuph
 * @date 2021-04-01 13:08:06
 */
@Data
@TableName("order")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "订单管理")
public class Order extends Model<Order> {
private static final long serialVersionUID = 1L;

    /**
     * 
     */
    @TableId
    @ApiModelProperty(value="")
    private Long id;
    /**
     * 订单渠道
     */
    @ApiModelProperty(value="订单渠道")
    private String channel;
    /**
     * 订单编号
     */
    @ApiModelProperty(value="订单编号")
    private String orderNo;
    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Long userId;
    /**
     * 订单状态
     */
    @ApiModelProperty(value="订单状态")
    private Integer status;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer skuOriginalTotalPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer skuTotalPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer freightPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer couponPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long couponId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long groupShopId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer actualPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer payPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String payId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String payChannel;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime gmtPay;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String shipNo;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String shipCode;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime gmtShip;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime gmtConfirm;
    /**
     * 若province字段为空，表示无需收货地址
     */
    @ApiModelProperty(value="若province字段为空，表示无需收货地址")
    private String province;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String city;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String county;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String address;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String phone;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String consignee;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String mono;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer adminMonoLevel;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String adminMono;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String refundReason;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime gmtUpdate;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private LocalDateTime gmtCreate;
    }
