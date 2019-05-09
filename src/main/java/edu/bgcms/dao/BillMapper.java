package edu.bgcms.dao;

import edu.bgcms.model.bill.Bill;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(Bill record);

    int insertSelective(Bill record);

    Bill selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(Bill record);

    int updateByPrimaryKey(Bill record);
    @Select("SELECT * FROM `bill` ORDER BY doTime")
    List<Bill> selectAll();
}