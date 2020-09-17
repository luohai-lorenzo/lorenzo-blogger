package com.luohai.myblogger.web;

import com.luohai.myblogger.domain.User;
import com.luohai.myblogger.service.UserService;
import com.luohai.myblogger.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    /**
     * 注册控制器
     * @param act
     * @param pwd
     * @param nickName
     * @param userName
     * @param qq
     * @param email
     * @param phone
     * @param isDomain
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public boolean register(String act, String pwd, String nickName,
                           String userName, String qq, String email,
                           String phone, String isDomain){
        User users = new User();
        Integer qqs = Integer.valueOf(qq);
        Integer isDomains = Integer.valueOf(isDomain);

        users.setAct(act);
        users.setPwd(pwd);
        users.setNickName(nickName);
        users.setUserName(userName);
        users.setEmail(email);
        users.setPhone(phone);
        users.setQq(qqs);
        users.setIsDomain(isDomains);
        users.setUserTime(new Date());

        boolean booleans = userService.insertUserAll(users);

        if (!booleans){
            return false;
        }
        return true;
    }


}
