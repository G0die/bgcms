package edu.bgcms.service.boardGame;

import edu.bgcms.dao.BoardGameMapper;
import edu.bgcms.model.boardGame.BoardGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BoardGameService {

    @Autowired
    private BoardGameMapper boardGameMapper;

    public List<BoardGame> getList() {
        List<BoardGame> list=boardGameMapper.selectAll();
        return list;
    }
    public void addViews( BoardGame bg) {
        bg.setViews(bg.getViews()+1);
        boardGameMapper.updateByPrimaryKey(bg);
    }

}
