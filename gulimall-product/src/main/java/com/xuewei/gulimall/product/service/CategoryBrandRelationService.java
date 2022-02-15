package com.xuewei.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewei.common.utils.PageUtils;
import com.xuewei.gulimall.product.entity.CategoryBrandRelationEntity;

import java.util.Map;

/**
 * 品牌分类关联
 *
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-02-15 22:45:32
 */
public interface CategoryBrandRelationService extends IService<CategoryBrandRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

