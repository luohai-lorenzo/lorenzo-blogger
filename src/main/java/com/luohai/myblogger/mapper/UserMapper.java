package com.luohai.myblogger.mapper;

import com.luohai.myblogger.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 通过用户输入的账号密码返回
     * @return
     */
    User selectUserByAct(@Param("act") String act,@Param("pwd") String pwd);

    int insertUser(User user);

}
