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
 * 
 *
 * @author wuph
 * @date 2021-04-01 11:29:24
 */
@Data
@TableName("spu")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class Spu extends Model<Spu> {
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
    private Integer originalPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer price;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer vipPrice;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String title;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer sales;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String img;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String detail;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String description;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long categoryId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long freightTemplateId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String unit;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer status;
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
