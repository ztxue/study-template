package com.example.demo1210.mapper;

import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {


    @Select("<script>" +
            "SELECT " +
            " d.'id',d.'name',d.'levels',d.'user_name',d.'tel'" +
            " FROM tb_dept d" +
            "<where>" +
            " d.'is_deleted'=0" +
            "</where>" +
            "</script>")
    List<Dept> deptList();

    @Select("<script>" +
            "SELECT " +
            "d.'id',d.'name',d.'levels',d.'user_name',d.'tel' " +
            "FROM tb_dept d" +
            "<where>" +
            " d.'is_deleted' = 0 " +
            "</where>" +
            "AND d.'id' = #{id}" +
            "</script>")
    int getOne(@Param("id") int id);

    @Select("<script>" +
            "SELECT" +
            " count(*) " +
            " FROM tb_staff s" +
            "<where>" +
            " s.`is_deleted`=0" +
            " AND s.dept_id IN " +
            " <foreach index=\"index\" collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\">" +
            " #{ids,jdbcType=INTEGER}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int selectCountByOrgId(@Param("ids") Set<Integer> ids);
}
