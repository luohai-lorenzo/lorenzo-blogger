package com.luohai.myblogger.service.impl;

import com.luohai.myblogger.domain.User;
import com.luohai.myblogger.mapper.UserMapper;
import com.luohai.myblogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/2/12 15:47
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserForMessage(String act,String pwd) {

        User user;

        if (act == null && pwd == null){
          return user = null;
        };

        user = userMapper.selectUserByAct(act, pwd);

        if (user == null){
            User users = new User();
            users.setId(0);
            return users;
        }

    return user;
    }

    @Override
    public boolean insertUserAll(User user) {

        int num = userMapper.insertUser(user);

        if (num <= 0){
            return false;
        }

        return true;
    }
}
