package com.cyan.mapper;

import com.cyan.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

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

//    使用 @Param("参数名称") 标记每一个参数，在映射配置文件中就需要使用 #{参数名称} 进行占位
    List<Brand> selectByCondition(
            @Param("status")int status,
            @Param("companyName")String companyName, @Param("brandName")String brandName);

//    将多个参数封装成一个 实体对象 ，将该实体对象作为接口的方法参数。
//    该方式要求在映射配置文件的SQL中使用 #{内 容} 时，里面的内容必须和实体类属性名保持一致。
    List<Brand> selectByCondition(Brand brand);

//    将多个参数封装到map集合中，将map集合作为接口的方法参数。该方式要求在映射配置文件的SQL中使用 #{内容}
//    时，里面的内容必须和map集合中键的名称一致。
    List<Brand> selectByCondition(Map map);
}