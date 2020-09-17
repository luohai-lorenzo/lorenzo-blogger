package com.luohai.myblogger.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: MbArticle
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 19:29
 **/
public class MbArticle implements Serializable {

    private String uuid;

    private String essayAddress;

    private String label;

    private Integer lookNumber;

    private Integer commentNumber;

    private Date postedTime;

    private String title;

    private String district;

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEssayAddress() {
        return essayAddress;
    }

    public void setEssayAddress(String essayAddress) {
        this.essayAddress = essayAddress;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getLookNumber() {
        return lookNumber;
    }

    public void setLookNumber(Integer lookNumber) {
        this.lookNumber = lookNumber;
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "MbArticle{" +
                "uuid=" + uuid +
                ", essayAddress='" + essayAddress + '\'' +
                ", lableId=" + label+
                ", lookNumber=" + lookNumber +
                ", commentNumber=" + commentNumber +
                ", postedTime=" + postedTime +
                ", title='" + title + '\'' +
                ", districtId=" + district +
                '}';
    }
}
