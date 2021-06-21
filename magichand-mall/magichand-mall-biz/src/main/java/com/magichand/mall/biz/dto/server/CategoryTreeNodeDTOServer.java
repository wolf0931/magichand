package com.magichand.mall.biz.dto.server;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.magichand.common.core.util.R;
import com.magichand.mall.biz.constant.ResultMessageConstants;
import com.magichand.mall.biz.dto.CategoryTreeNodeDTO;
import com.magichand.mall.biz.entity.Category;
import com.magichand.mall.biz.mapper.CategoryMapper;
import com.magichand.mall.biz.mapper.SpuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 为ElementUi适配的树结构
 * Created by magichand on 2019/7/12.
 */
@Service
@RequiredArgsConstructor
public class CategoryTreeNodeDTOServer {

	private final CategoryMapper categoryMapper;

	private final SpuMapper spuMapper;


	public R deleteCategory(Long adminId, Long id){
		QueryWrapper categoryWrapper = new QueryWrapper();
		categoryWrapper.eq("parent_id", id);
		Integer count_category = categoryMapper.selectCount(categoryWrapper);
		QueryWrapper spuWrapper = new QueryWrapper();
		categoryWrapper.eq("parent_id", id);
		Integer count_spu = spuMapper.selectCount(spuWrapper);
		if (count_category != 0 || count_spu != 0) {
			return R.failed(ResultMessageConstants.CATEGORY_OUGHT_TO_EMPTY);
		}
		if (categoryMapper.deleteById(id) > 0){
			return R.failed(ResultMessageConstants.DELETE_S);
		}
		return R.failed();
	}


	public List<CategoryTreeNodeDTO> getCategoryList() {
		QueryWrapper wrapper = new QueryWrapper();
		List<Category> categoryDOS = categoryMapper.selectList(wrapper);
		List<CategoryTreeNodeDTO> list = categoryDOS.stream().map(item -> {
			CategoryTreeNodeDTO dto = new CategoryTreeNodeDTO();
			dto.setLabel(item.getTitle());
			dto.setLevel(item.getLevel());
			dto.setValue(item.getId());
			dto.setParent(item.getParentId());
			dto.setIconUrl(item.getIconUrl());
			dto.setPicUrl(item.getPicUrl());
			if (item.getLevel() == 0) {
				dto.setFullName(dto.getLabel());
			}
			return dto;
		}).collect(Collectors.toList());

		for (CategoryTreeNodeDTO cOne : list) {

			for (CategoryTreeNodeDTO cTwo : list) {
				if (cOne.getParent().equals(cTwo.getValue())) {
					cOne.setFullName(cTwo.getFullName() + "/" + cOne.getLabel());
					break;
				}
			}

		}
		return list;
	}

	/**
	 * 得到类型
	 * @return
	 */
	public List<CategoryTreeNodeDTO> categoryTree() {
		List<Category> categoryDOS = categoryMapper.selectList(null);
		List<CategoryTreeNodeDTO> list = categoryDOS.stream().filter((item) -> (item.getParentId().equals(0L))).map(item -> {
			CategoryTreeNodeDTO dto = new CategoryTreeNodeDTO();
			dto.setLabel(item.getTitle());
			dto.setLevel(0);
			dto.setFullName(dto.getLabel());
			dto.setValue(item.getId());
			dto.setChildren(new LinkedList<>());
			return dto;
		}).collect(Collectors.toList());
		list.forEach(item -> {
			categoryDOS.forEach(categoryDO -> {
				if (categoryDO.getParentId().equals(item.getValue())) {
					CategoryTreeNodeDTO categoryTreeNodeDTO = new CategoryTreeNodeDTO();
					categoryTreeNodeDTO.setChildren(new LinkedList<>());
					categoryTreeNodeDTO.setValue(categoryDO.getId());
					categoryTreeNodeDTO.setLabel(categoryDO.getTitle());
					categoryTreeNodeDTO.setLevel(1);
					categoryTreeNodeDTO.setParent(item.getValue());
					categoryTreeNodeDTO.setFullName(item.getFullName() + "/" + categoryDO.getTitle());
					item.getChildren().add(categoryTreeNodeDTO);
					categoryDOS.forEach(subCategoryDO -> {
						if (subCategoryDO.getParentId().equals(categoryTreeNodeDTO.getValue())) {
							CategoryTreeNodeDTO childCategoryNodeDTO = new CategoryTreeNodeDTO();
							childCategoryNodeDTO.setLabel(subCategoryDO.getTitle());
							childCategoryNodeDTO.setValue(subCategoryDO.getId());
							childCategoryNodeDTO.setLevel(2);
							childCategoryNodeDTO.setParent(categoryTreeNodeDTO.getValue());
							childCategoryNodeDTO.setFullName(categoryTreeNodeDTO.getFullName() + "/" + subCategoryDO.getTitle());
							categoryTreeNodeDTO.getChildren().add(childCategoryNodeDTO);
						}
					});
				}
			});
		});
		return list;
	}
}
