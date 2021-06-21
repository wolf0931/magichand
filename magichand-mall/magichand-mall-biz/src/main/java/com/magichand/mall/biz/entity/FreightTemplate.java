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
 * 运费模板
 *
 * @author magichand code generator
 * @date 2021-04-02 14:12:56
 */
@Data
@TableName("freight_template")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "运费模板")
public class FreightTemplate extends Model<FreightTemplate> {
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
	private String templateName;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private String spuLocation;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer deliveryDeadline;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer defaultFreePrice;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer defaultFirstNum;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer defaultFirstMoney;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer defaultContinueNum;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer defaultContinueMoney;
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
