package com.example.demo1210.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1210.bean.StaffBean;
import com.example.demo1210.entity.Staff;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 张童学
 * @since 2021-12-10
 */
@Mapper
public interface StaffMapper extends BaseMapper<Staff> {

    /**
     * 注册
     */
    @Insert("<script>" +
            "Insert Into" +
            " tb_staff" +
            "(user_name, password, dept_name, age, sex, email, tel, address)" +
            " Value" +
            "(#{staff.userName},#{staff.password},#{staff.deptName},#{staff.age},#{staff.sex},#{staff.email},#{staff.tel},#{staff.address})" +
            "</script>")
    int addStaff(@Param("staff") Staff staff);
    /**
     * 查重
     */
    @Select("<script>" +
            "SELECT " +
            " count(*)" +
            " FROM tb_staff" +
            " <where>" +
            " is_deleted=0 " +
            " AND user_name=#{userName,jdbcType=VARCHAR}" +
            " </where>" +
            "</script>")
    int getOneByName(@Param("userName") String userName);

    /**
     * 登录
     */
    @Select("<script>" +
            "SELECT" +
            " u.user_id" +
            " ,u.user_name" +
            " ,u.password" +
            " ,u.dept_id" +
            " ,u.dept_name" +
            " ,u.age" +
            " ,u.sex" +
            " ,u.tel" +
            " ,u.levels" +
            " ,u.email" +
            " ,u.address" +
            " FROM tb_staff u " +
            "<where>" +
            " u.`is_deleted`=0" +
            "<if test=\"userName!=null and userName!=''\">" +
            " AND u.user_name=#{userName,jdbcType=VARCHAR}" +
            "</if>" +
            "<if test=\"password!=null and password!=''\">" +
            " AND u.password=#{password,jdbcType=VARCHAR}" +
            "</if>" +
            "</where>" +
            " LIMIT 1" +
            "</script>")
    StaffBean login(@Param("userName") String loginName, @Param("password") String loginPassword);
}
