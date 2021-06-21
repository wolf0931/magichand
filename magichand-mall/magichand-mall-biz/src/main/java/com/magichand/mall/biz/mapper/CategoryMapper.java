package com.magichand.mall.biz.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.magichand.mall.biz.entity.Category;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品目录
 *
 * @author wph
 * @date 2021-03-26 13:53:43
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
