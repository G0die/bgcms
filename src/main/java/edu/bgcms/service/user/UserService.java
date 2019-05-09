package edu.bgcms.service.user;

import edu.bgcms.dao.UserMapper;
import edu.bgcms.model.user.User;
import edu.bgcms.model.user.UserExample;
import org.hibernate.validator.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {


    @Autowired
    private UserMapper userMapper;
    /*
     * 检验用户登录业务
     *
     */

    public User checkLogin(String account, String pwd) {
        User user = userMapper.checkLogin(account);
        if(user != null && user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> getList(String keyWord) {
        UserExample userExample = new UserExample();
        if(!StringHelper.isNullOrEmptyString(keyWord)){
            userExample.createCriteria().andUsernameLike(keyWord);
        }
        List<User> list=userMapper.selectByExample(userExample);
        return list;
    }
}

