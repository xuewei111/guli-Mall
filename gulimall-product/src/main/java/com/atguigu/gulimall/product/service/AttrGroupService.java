package com.atguigu.gulimall.product.service;

import com.atguigu.gulimall.product.entity.AttrEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.AttrGroupEntity;

import java.util.List;
import java.util.Map;

/**
 * 属性分组
 *
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-08-25 23:32:38
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params,Long catelogId);
}

