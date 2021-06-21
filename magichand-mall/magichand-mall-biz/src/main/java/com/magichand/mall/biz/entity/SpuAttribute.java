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
 * @author magichand code generator
 * @date 2021-04-02 14:06:23
 */
@Data
@TableName("spu_attribute")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "")
public class SpuAttribute extends Model<SpuAttribute> {
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
    private String attribute;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String value;
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
