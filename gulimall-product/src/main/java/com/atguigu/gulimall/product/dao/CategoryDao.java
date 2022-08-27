package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-08-25 23:32:38
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
