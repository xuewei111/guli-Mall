package com.atguigu.gulimall.product.service.impl;

import com.atguigu.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
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
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryBrandRelationService categoryBrandRelationService;

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

    @Override
    public void removeMenuByIds(List<Long> asList) {
        baseMapper.deleteBatchIds(asList);
    }

    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = findParentPath(catelogId, paths);
        Collections.reverse(parentPath);

        return paths.toArray(new Long[parentPath.size()]);
    }

    @Override
    @Transactional
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCateGory(category.getCatId(),category.getName());
    }

    private List<Long> findParentPath(Long catelogId,List<Long> paths){
        // 1.收集当前节点ID
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid() != 0) {
            findParentPath(byId.getParentCid(),paths);
        }
        return paths;
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