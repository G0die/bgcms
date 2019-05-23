package edu.bgcms.dao;

import edu.bgcms.model.order.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String outTradeNo);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String outTradeNo);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}