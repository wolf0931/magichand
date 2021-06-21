package com.magichand.mall.biz.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.magichand.common.core.util.R;
import com.magichand.common.log.annotation.SysLog;
import com.magichand.mall.biz.dto.CategoryTreeNodeDTO;
import com.magichand.mall.biz.dto.server.CategoryTreeNodeDTOServer;
import com.magichand.mall.biz.entity.Category;
import com.magichand.mall.biz.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


/**
 * 商品目录
 *
 * @author wph
 * @date 2021-03-26 13:53:43
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/category" )
@Api(value = "category", tags = "商品目录管理")
public class CategoryController {

    private final  CategoryService categoryService;

    private final CategoryTreeNodeDTOServer categoryTreeNodeDTOServer;

    /**
     * 分页查询
     * @param page 分页对象
     * @param category 商品目录
     * @return
     */
    @ApiOperation(value = "分页查询", notes = "分页查询")
    @GetMapping("/page" )
    @PreAuthorize("@pms.hasPermission('biz_category_get')" )
    public R getCategoryPage(Page page, Category category) {
		List<Category> categoryDOS = categoryService.page(page, Wrappers.query(category)).getRecords();
		List<CategoryTreeNodeDTO> totalCategory = categoryTreeNodeDTOServer.getCategoryList();
		List<CategoryTreeNodeDTO> list = categoryDOS.stream().map(item -> {
			CategoryTreeNodeDTO dto = new CategoryTreeNodeDTO();
			for (CategoryTreeNodeDTO temp : totalCategory) {
				if (temp.getValue().equals(item.getId())) {
					BeanUtils.copyProperties(temp, dto);
					return dto;
				}
			}
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
		page.setOrders(list);
        return R.ok(page);
    }


    /**
     * 通过id查询商品目录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id查询", notes = "通过id查询")
    @GetMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_category_get')" )
    public R getById(@PathVariable("id" ) Long id) {
        return R.ok(categoryService.getById(id));
    }

    /**
     * 新增商品目录
     * @param category 商品目录
     * @return R
     */
    @ApiOperation(value = "新增商品目录", notes = "新增商品目录")
    @SysLog("新增商品目录" )
    @PostMapping
    @PreAuthorize("@pms.hasPermission('biz_category_add')" )
    public R save(@RequestBody Category category) {
        return R.ok(categoryService.save(category));
    }

    /**
     * 修改商品目录
     * @param category 商品目录
     * @return R
     */
    @ApiOperation(value = "修改商品目录", notes = "修改商品目录")
    @SysLog("修改商品目录" )
    @PutMapping
    @PreAuthorize("@pms.hasPermission('biz_category_edit')" )
    public R updateById(@RequestBody Category category) {
        return R.ok(categoryService.updateById(category));
    }

    /**
     * 通过id删除商品目录
     * @param id id
     * @return R
     */
    @ApiOperation(value = "通过id删除商品目录", notes = "通过id删除商品目录")
    @SysLog("通过id删除商品目录" )
    @DeleteMapping("/{id}" )
    @PreAuthorize("@pms.hasPermission('biz_category_del')" )
    public R removeById(@PathVariable Long id) {
        return R.ok(categoryTreeNodeDTOServer.deleteCategory(null,id));
    }

	@ApiOperation(value = "查询父类目", notes = "查询父类目")
	@SysLog("查询父类目" )
	@GetMapping("/tree" )
	public R tree() {
		return R.ok(categoryTreeNodeDTOServer.categoryTree());
	}

}
