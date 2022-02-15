package com.xuewei.gulimall.product.dao;

import com.xuewei.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-02-15 22:45:32
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
