package com.luohai.myblogger.domain;

import java.io.Serializable;

/**
 * @ClassName: MbDistrict
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 21:07
 **/
public class MbDistrict implements Serializable {

    private Integer id;

    private String articleDistrict;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticleDistrict() {
        return articleDistrict;
    }

    public void setArticleDistrict(String articleDistrict) {
        this.articleDistrict = articleDistrict;
    }

    @Override
    public String toString() {
        return "MbDistrict{" +
                "id=" + id +
                ", articleDistrict='" + articleDistrict + '\'' +
                '}';
    }
}
