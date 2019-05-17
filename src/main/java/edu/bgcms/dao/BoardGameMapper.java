package edu.bgcms.dao;

import edu.bgcms.model.boardGame.BoardGame;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BoardGameMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(BoardGame record);

    int insertSelective(BoardGame record);

    BoardGame selectByPrimaryKey(String uuid);

    int updateByPrimaryKeySelective(BoardGame record);

    int updateByPrimaryKey(BoardGame record);
    //----------------------
    @Select("SELECT * FROM `boardgame` ORDER BY stars DESC,views DESC")
    public List<BoardGame> selectAll();

    @Select("SELECT uuid,name FROM `boardgame` ORDER BY stars DESC,views DESC")
    public List<BoardGame> selectNameAll();
}