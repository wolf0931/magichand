package com.magichand.mall.biz.dto.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.mall.biz.constant.SpuStatusType;
import com.magichand.mall.biz.dto.GoodDto;
import com.magichand.mall.biz.entity.Category;
import com.magichand.mall.biz.entity.Good;
import com.magichand.mall.biz.mapper.CategoryMapper;
import com.magichand.mall.biz.mapper.GoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * 为ElementUi适配的树结构
 * Created by magichand on 2019/7/12.
 */
@Service
@RequiredArgsConstructor
public class GoodsDTOServer {

	private final CategoryMapper categoryMapper;

	private final GoodMapper goodMapper;


	public Page<GoodDto> list(Page page, Good good){
		QueryWrapper<Good> wrapper = new QueryWrapper<Good>();
		if (good.getCategoryId() != null){
			long categoryId = good.getCategoryId();
			List<Category> childrenList = categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_id", categoryId));
			LinkedList<Long> childrenIds = new LinkedList<>();
			if (CollectionUtils.isEmpty(childrenList)) {
				// 则传入类目为三级类目
				childrenIds.add(categoryId);
			}else {
				Category category = categoryMapper.selectById(categoryId);
				if (category.getParentId() != 0L) {
					//二级分类
					childrenList.forEach(item -> {
						childrenIds.add(item.getId());
					});
				}else {
					//一级分类
					childrenList.forEach(item -> {
						List<Category> leafList = categoryMapper.selectList(new QueryWrapper<Category>().eq("parent_id", item.getId()));
						if (!CollectionUtils.isEmpty(leafList)) {
							leafList.forEach(leafItem -> {
								childrenIds.add(leafItem.getId());
							});
						}
					});
				}
			}
			wrapper.in("category_id", childrenIds);
		}
		Integer status = good.getStatus();
		if (status != null) {
			wrapper.eq("status", status.intValue() <= SpuStatusType.STOCK.getCode() ? SpuStatusType.STOCK.getCode() : SpuStatusType.SELLING.getCode());
		}
//		String barcode = goods.getBarcode();
//		if (barcode != null) {
//			List<Sku> skuDOList = goodsMapper.selectList(new QueryWrapper<Sku>().eq("bar_code", barcode));
//			if (!CollectionUtils.isEmpty(skuDOList)) {
//				Sku skuDO = skuDOList.get(0);
//				wrapper.eq("id", skuDO.getSpuId());
//			}
//		}
		page = goodMapper.selectPage(page,wrapper);
//		List<Goods> goodsList = page.getRecords();
//		List<GoodDto> spuDTOList = new ArrayList<>();
//		goodsList.forEach(item -> {
//			GoodDto goodDto = new GoodDto();
//			BeanUtils.copyProperties(item, goodDto);
//			List<Goods> skuDOList = goodsMapper.selectList(new QueryWrapper<Goods>().eq("spu_id", item.getId()));
//			goodDto.setSkuList(skuDOList);
//			spuDTOList.add(goodDto);
//		});
//		page.setRecords(spuDTOList);
		return page;
	}

}
