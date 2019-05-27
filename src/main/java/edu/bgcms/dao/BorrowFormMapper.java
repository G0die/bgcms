package edu.bgcms.dao;

import edu.bgcms.dto.BorrowFormDto;
import edu.bgcms.model.workFlow.BorrowForm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BorrowFormMapper {
    int deleteByPrimaryKey(String uuid);

    int insert(BorrowForm record);

    int insertSelective(BorrowForm record);

    BorrowForm selectByPrimaryKey(String uuid);



    int updateByPrimaryKeySelective(BorrowForm record);

    int updateByPrimaryKeyWithBLOBs(BorrowForm record);

    int updateByPrimaryKey(BorrowForm record);
//----------
    @Select("SELECT bf.*,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.cur_user)as curUserName ,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.applicant)as applicantName ,\n" +
            "(SELECT `boardgame`.`name` FROM `boardgame` WHERE uuid =bf.bg_id)as bgName \n" +
            "FROM `borrow_Form` as bf WHERE uuid = #{uuid} ")
    BorrowFormDto selectByPKRetunDto(String uuid);

    @Select("SELECT bf.*,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.cur_user)as curUserName ,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.applicant)as applicantName ,\n" +
            "(SELECT `boardgame`.`name` FROM `boardgame` WHERE uuid =bf.bg_id)as bgName \n" +
            "FROM `borrow_Form` as bf WHERE bf.applicant = #{uuid} ")
    List<BorrowFormDto> selectListByApplicant(String uuid);


    @Select("SELECT bf.*,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.cur_user)as curUserName ,\n" +
            "(SELECT `user`.username FROM `user` WHERE uuid =bf.applicant)as applicantName ,\n" +
            "(SELECT `boardgame`.`name` FROM `boardgame` WHERE uuid =bf.bg_id)as bgName \n" +
            "FROM `borrow_Form` as bf WHERE (bf.applicant = #{uuid} and cur_step = 1)or (bf.cur_user = #{uuid} and cur_step = 0) ")
    List<BorrowFormDto> selectListByApprover(String uuid);
}