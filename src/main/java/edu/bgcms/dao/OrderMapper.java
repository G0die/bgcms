package edu.bgcms.dao;

import edu.bgcms.dto.OrderDto;
import edu.bgcms.model.order.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String outTradeNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String outTradeNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    //---
    @Select("SELECT o.*," +
            "(SELECT username FROM `user` WHERE uuid = o.user_id)" +
            " FROM `orders` as o WHERE status = 'success' AND obj_id = #{uuid} ORDER BY create_time ")
    List<OrderDto> getJoinCfListByBgId(String uuid);
}