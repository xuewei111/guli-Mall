package com.xuewei.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewei.common.utils.PageUtils;
import com.xuewei.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-02-15 22:45:32
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

