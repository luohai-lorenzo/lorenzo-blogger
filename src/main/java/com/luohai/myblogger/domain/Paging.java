package com.luohai.myblogger.domain;

import org.hibernate.validator.constraints.EAN;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: paging
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/5 0:33
 **/
public class Paging implements Serializable {

    /**
     * 总页数
     */
    private Integer numberPages;

    /**
     * 文章信息集合
     */
    private List<MbArticle> mbArticleList;

    /**
     * 当前页数
     */
    private Integer numberPage;

    public Integer getNumberPages() {
        return numberPages;
    }

    public void setNumberPages(Integer numberPages) {
        this.numberPages = numberPages;
    }

    public List<MbArticle> getMbArticleList() {
        return mbArticleList;
    }

    public void setMbArticleList(List<MbArticle> mbArticleList) {
        this.mbArticleList = mbArticleList;
    }

    public Integer getNumberPage() {
        return numberPage;
    }

    public void setNumberPage(Integer numberPage) {
        this.numberPage = numberPage;
    }

    @Override
    public String toString() {
        return "paging{" +
                "numberPages=" + numberPages +
                ", mbArticleList=" + mbArticleList +
                ", numberPage=" + numberPage +
                '}';
    }
}
