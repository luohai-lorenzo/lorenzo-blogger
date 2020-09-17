package com.luohai.myblogger.domain;

import java.io.Serializable;

/**
 * @ClassName: MbLabel
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 21:07
 **/
public class MbLabel implements Serializable {

    private Integer id;

    private String labelText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabelText() {
        return labelText;
    }

    public void setLabelText(String lableText) {
        this.labelText = lableText;
    }

    @Override
    public String toString() {
        return "MbLabel{" +
                "id=" + id +
                ", lableText='" + labelText + '\'' +
                '}';
    }
}
