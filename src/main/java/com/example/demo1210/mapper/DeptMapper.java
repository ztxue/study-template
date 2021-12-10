package com.example.demo1210.mapper;

import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {


    @Select("<script>" +
            "select d.id,d.name,d.levels,d.user_name,d.tel" +
            "from tb_dept d" +
            "</script>")
    List<Dept> deptList();

    @Select("<script>" +
            "select *" +
            "from tb_dept d" +
            "where d.is_deleted = 0" +
            "and d.id = #{id}" +
            "</script>")
    int getOne(@Param("id") int id);
}
