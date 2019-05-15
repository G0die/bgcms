package edu.bgcms.dao;

import edu.bgcms.model.Test;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Test record);

    int insertSelective(Test record);

    Test selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Test record);

    int updateByPrimaryKey(Test record);

    @Select("SELECT * FROM `test`")
    List<Test> selectSurplus();
}