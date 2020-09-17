package com.luohai.myblogger.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: user
 * @Description: 用户表实体类
 * @Author: 罗三炮
 * @Date: 2020/2/12 15:42
 **/
public class User implements Serializable {

    private Integer id;

    private String act;

    private String pwd;

    private String email;

    private String phone;

    private String nickName;

    private Date userTime;

    private Integer isDomain;

    private Integer qq;

    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Date getUserTime() {
        return userTime;
    }

    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }

    public Integer getIsDomain() {
        return isDomain;
    }

    public void setIsDomain(Integer isDomain) {
        this.isDomain = isDomain;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", act='" + act + '\'' +
                ", pwd='" + pwd + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", nickName='" + nickName + '\'' +
                ", userTime=" + userTime +
                ", isDomain=" + isDomain +
                ", qq=" + qq +
                ", userName='" + userName + '\'' +
                '}';
    }
}
