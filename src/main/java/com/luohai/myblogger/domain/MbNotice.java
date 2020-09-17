package com.luohai.myblogger.domain;

import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: MbNotice
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/3/3 20:21
 **/
public class MbNotice implements Serializable {

    private Integer id;

    private String noticeBody;

    private Date noticeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeBody() {
        return noticeBody;
    }

    public void setNoticeBody(String noticeBody) {
        this.noticeBody = noticeBody;
    }

    public Date getNoticeDate() {
        return noticeDate;
    }

    public void setNoticeDate(Date noticeDate) {
        this.noticeDate = noticeDate;
    }

    @Override
    public String toString() {
        return "MbNotice{" +
                "id=" + id +
                ", noticeBody='" + noticeBody + '\'' +
                ", noticeDate=" + noticeDate +
                '}';
    }
}
