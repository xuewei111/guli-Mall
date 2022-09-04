package com.atguigu.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.common.utils.PageUtils;
import com.atguigu.common.utils.Query;

import com.atguigu.gulimall.product.dao.CategoryDao;
import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.atguigu.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        // 1. 查出所有的分类
        List<CategoryEntity> entities = baseMapper.selectList(null);
        // 2.组装成父子的树形结构
        List<CategoryEntity> collect = entities.stream()
                .filter(item -> item.getParentCid().longValue() == 0)
                .map(item -> {
                    item.setChildren(getChildrens(item,entities));
                    return item;
                })
                .sorted(Comparator.comparingInt(a -> (a.getSort() == null ? 0 : a.getSort())))
                .collect(Collectors.toList());
        return collect;
    }

    // 递归查询所有菜单的子菜单
    private List<CategoryEntity> getChildrens(CategoryEntity category,List<CategoryEntity> categoryEntityList) {
        List<CategoryEntity> collect = categoryEntityList.stream()
                .filter(item -> item.getParentCid().equals(category.getCatId()))
                .map(item -> {
                    item.setChildren(getChildrens(item, categoryEntityList));
                    return item;
                })
                .sorted(Comparator.comparingInt(a -> (a.getSort() == null ? 0 : a.getSort())))
                .collect(Collectors.toList());
        return collect;
    }

}