package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-08-27 23:25:17
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
