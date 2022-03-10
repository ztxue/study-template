package com.example.demo1210.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1210.entity.Timbre;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author: 张童学
 * @description: 音色（发言人）管理 Mapper
 * @date: 2022-02-21
 */
@Mapper
public interface TimbreMapper extends BaseMapper<Timbre> {


    @Select("<script>" +
            "SELECT" +
            " COUNT(*) " +
            "FROM" +
            " timbre " +
            "WHERE" +
            " name = #{name,jdbcType=VARCHAR}" +
            "AND" +
            " deleted = 0" +
            "</script>")
    int check(@Param("name") String name);
}
