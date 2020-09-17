package com.luohai.myblogger.service;

import com.luohai.myblogger.domain.User;

import java.util.List;

public interface UserService {

    User selectUserForMessage(String act, String pwd);

    boolean insertUserAll(User user);

}
