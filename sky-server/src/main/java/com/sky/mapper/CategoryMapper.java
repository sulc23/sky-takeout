package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.Autofill;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Insert("insert into category (name,type,sort,status,create_time,update_time,create_user,update_user)" +
            "values(#{name},#{type},#{sort},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    @Autofill(value = OperationType.INSERT)
    void insert(Category category);

    Page<Category> pageQuert(CategoryPageQueryDTO categoryPageQueryDTO);

    @Delete("delete from category where id=#{id}")
    void deleteById(Long id);

    @Autofill(value = OperationType.UPDATE)
    void update(Category category);

    List<Category> list(Integer type);
}
