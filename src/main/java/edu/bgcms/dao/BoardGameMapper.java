package edu.bgcms.dao;

import edu.bgcms.model.BoardGame;

public interface BoardGameMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(BoardGame record);

    int insertSelective(BoardGame record);

    BoardGame selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(BoardGame record);

    int updateByPrimaryKey(BoardGame record);
}