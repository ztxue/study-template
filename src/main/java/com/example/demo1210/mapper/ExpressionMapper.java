package com.example.demo1210.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo1210.entity.Expression;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

/**
 * @author: 张童学
 * @description: Mapper
 * @date: 2022-02-19
 */
@Mapper
public interface ExpressionMapper extends BaseMapper<Expression> {
    /**
     * 列表
     */
    @Select("<script>" +
            "SELECT" +
            " t.`id`" +
            " ,t.`anthomaniac`" +
            " ,t.`awaken`" +
            " ,t.`happy`" +
            " ,t.`lovely`" +
            " ,t.`sad`" +
            " ,t.`shyness`" +
            " ,t.`sorry`" +
            " ,t.`speak`" +
            " ,t.`think`" +
            " ,t.`unawaken`" +
            " ,t.`awkward`" +
            " ,t.`proud`" +
            " ,t.`angry`" +
            " ,t.`cry`" +
            " FROM expression t " +
            "</script>")
    List<Expression> selectExpressionList();

    /**
     * 删除
     */
    @Delete("<script>" +
            "DELETE FROM expression" +
            "<where>" +
            " id IN " +
            " <foreach index=\"index\" collection=\"ids\" item=\"id\" open=\"(\" separator=\",\" close=\")\">" +
            " #{id,jdbcType=INTEGER}" +
            " </foreach>" +
            "</where>" +
            "</script>")
    int deleteExpression(@Param("ids") Set<Integer> ids);
}
