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
 * 评价商品

 *
 * @author wuph
 * @date 2021-04-01 13:12:03
 */
@Data
@TableName("appraise")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "评价商品 ")
public class Appraise extends Model<Appraise> {
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
    private Long skuId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long orderId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long userId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String content;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer score;
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
