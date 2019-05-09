package edu.bgcms.service.boardGame;

import edu.bgcms.dao.BoardGameMapper;
import edu.bgcms.model.boardGame.BoardGame;
import edu.bgcms.model.boardGame.BoardGameExample;
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
        List<BoardGame> list=boardGameMapper.selectByExample(new BoardGameExample());
        return list;
    }
}
