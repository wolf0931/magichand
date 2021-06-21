package com.magichand.mall.biz.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.mall.biz.entity.Category;
import com.magichand.mall.biz.entity.GroupShop;
import com.magichand.mall.biz.entity.SpuAttribute;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

/**
 * @author wuph
 * @PackageName:com.magichand.mall.biz.dto
 * @className:GoodDto
 * @Description:
 * @date 2021/4/2 3:06 下午
 */
@Data
@ApiModel(value = "前端商品信息")
public class GoodDto extends SuperDTO {

	private Integer originalPrice;

	private Integer price;

	private Integer vipPrice;

	private Integer stock;

	private Integer sales;

	private String title;

	/**
	 * 主图
	 */
	private String img;

	/**
	 * 后面的图，仅在详情接口才出现
	 */
	private List<String> imgList;

	private String detail;

	private String description;

	private Long categoryId;

	private List<Long> categoryIds;

	private List<Category> categoryList;

	private List<SpuAttribute> attributeList;

	/**
	 * 商品的第一页(前10条)评价
	 */
	private Page<AppraiseResponseDTO> appraisePage;

	/**
	 * 商品现在携带的团购信息
	 */
	private GroupShop groupShop;

	private String unit;

	private Long freightTemplateId;

	private FreightTemplateDTO freightTemplate;

	private Boolean collect;

	private Integer status;

}
