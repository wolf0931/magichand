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
 * 商品目录
 *
 * @author wph
 * @date 2021-03-26 13:53:43
 */
@Data
@TableName("category")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "商品目录")
public class Category extends Model<Category>  {
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
    private String title;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Long parentId;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String iconUrl;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private String picUrl;
    /**
     * 
     */
    @ApiModelProperty(value="")
    private Integer level;
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
