package edu.bgcms.dao;

import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.model.boardGame.BoardGameExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardGameMapper {
    long countByExample(BoardGameExample example);

    int deleteByExample(BoardGameExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(BoardGame record);

    int insertSelective(BoardGame record);

    List<BoardGame> selectByExample(BoardGameExample example);

    BoardGame selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") BoardGame record, @Param("example") BoardGameExample example);

    int updateByExample(@Param("record") BoardGame record, @Param("example") BoardGameExample example);

    int updateByPrimaryKeySelective(BoardGame record);

    int updateByPrimaryKey(BoardGame record);
}