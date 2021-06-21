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
 * 运费模板价格
 *
 * @author magichand code generator
 * @date 2021-04-02 14:15:32
 */
@Data
@TableName("freight_template_carriage")
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "运费模板价格")
public class FreightTemplateCarriage extends Model<FreightTemplateCarriage> {
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
	private Long templateId;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private String designatedArea;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer freePrice;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer firstNum;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer firstMoney;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer continueNum;
	/**
	 *
	 */
	@ApiModelProperty(value="")
	private Integer continueMoney;
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
