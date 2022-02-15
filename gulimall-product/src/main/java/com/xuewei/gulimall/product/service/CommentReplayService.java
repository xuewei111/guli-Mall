package com.xuewei.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xuewei.common.utils.PageUtils;
import com.xuewei.gulimall.product.entity.CommentReplayEntity;

import java.util.Map;

/**
 * 商品评价回复关系
 *
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-02-15 22:45:32
 */
public interface CommentReplayService extends IService<CommentReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

