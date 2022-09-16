package com.cyan.mapper;

import com.cyan.pojo.Brand;

import java.util.List;

public interface BrandMapper {
    /**
     * 查询所有
     * @return 品牌列表
     */
    List<Brand> selectAll();

    /**
     * 根据id查询
     * @param id 品牌id
     * @return 品牌详情
     */
    Brand selectById(int id);
}