package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author xuewei
 * @email m13358109269_1@163.com
 * @date 2022-08-27 23:08:27
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
