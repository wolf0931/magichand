package com.magichand.mall.biz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.magichand.mall.biz.entity.Category;
import com.magichand.mall.biz.mapper.CategoryMapper;
import com.magichand.mall.biz.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 商品目录
 *
 * @author wph
 * @date 2021-03-26 13:53:43
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
