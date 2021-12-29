package com.example.demo1210.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo1210.bean.DeptBean;
import com.example.demo1210.entity.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

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
            " id,name,levels,user_name,tel" +
            " FROM tb_dept" +
            " <where>" +
            " is_deleted=0" +
            " </where>" +
            "</script>")
    List<Dept> deptList(@Param("deptBean") DeptBean deptBean);

    /**
     * listPage
     */
    @Select("<script>" +
            "SELECT " +
            " id,name,levels,user_name,tel" +
            " FROM tb_dept" +
            " <where>" +
            " is_deleted=0" +
            " <if test=\"param.userName!=null and param.userName!='' and param.userName!='null'\">" +
            " AND tb_dept.user_name like CONCAT('%',#{param.userName,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " <if test=\"param.name!=null and param.name!='' and param.name!='null'\">" +
            " AND tb_dept.name like CONCAT('%',#{param.name,jdbcType=VARCHAR},'%')" +
            " </if>" +
            " </where>" +
            " ORDER BY tb_dept.id" +
            "</script>")
    IPage<Dept> selectListPage(@Param("param") DeptBean param, @Param("page") Page<Dept> page);

    @Select("<script>" +
            "SELECT " +
            " d.id,d.name,d.levels,d.user_name,d.tel" +
            " FROM tb_dept d" +
            "<where>" +
            " d.'is_deleted' = 0 " +
            "</where>" +
            " AND d.id = #{id}" +
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
    Dept selectCountByOrgId(@Param("ids") Set<Integer> ids);

    @Delete("<script>" +
            " delete" +
            " from tb_dept" +
            " <where>" +
            " tb_dept.is_deleted=0" +
            " <if test=\"name!=null and name!=''\">" +
            " AND name = #{name}" +
            " </if>" +
            " </where>" +
            " </script>")
    int deleteByName(String name);

    @Update("<script>" +
            " update tb_dept" +
            " set tel=#{tel}" +
            " <where>" +
            " is_deleted=0" +
            " AND tel!=null and tel!=''" +
            " </where>" +
            " </script>")
    int updateTelByName(@Param("tel") String tel);

    @Insert("<script>" +
            " insert into " +
            " tb_dept" +
            " (name,levels,user_name,tel)" +
            " value" +
            " (#{name},#{levels},#{userName},#{tel})" +
            " </script>")
    int addDept(DeptBean deptBean);

    @Select("<script>" +
            "SELECT " +
            " count(*)" +
            " FROM tb_dept" +
            " <where>" +
            " is_deleted=0 " +
            " AND user_name=#{userName,jdbcType=VARCHAR}" +
            " </where>" +
            "</script>")
    int getOneByName(@Param("userName") String userName);
}
