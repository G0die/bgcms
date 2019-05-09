package edu.bgcms.dao;

import edu.bgcms.model.boardGameTag.BoardGameTag;
import edu.bgcms.model.boardGameTag.BoardGameTagExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardGameTagMapper {
    long countByExample(BoardGameTagExample example);

    int deleteByExample(BoardGameTagExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(BoardGameTag record);

    int insertSelective(BoardGameTag record);

    List<BoardGameTag> selectByExample(BoardGameTagExample example);

    BoardGameTag selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") BoardGameTag record, @Param("example") BoardGameTagExample example);

    int updateByExample(@Param("record") BoardGameTag record, @Param("example") BoardGameTagExample example);

    int updateByPrimaryKeySelective(BoardGameTag record);

    int updateByPrimaryKey(BoardGameTag record);
}