package com.luohai.myblogger.service.impl;

import com.luohai.myblogger.domain.MbArticle;
import com.luohai.myblogger.domain.Paging;
import com.luohai.myblogger.mapper.MbArticleMapper;
import com.luohai.myblogger.service.MbArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MbArticleServiceImpl
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 19:40
 **/
@Service
public class MbArticleServiceImpl implements MbArticleService {

    @Autowired
    MbArticleMapper mbArticleMapper;

    /**
     * 文章信息插入数据库中
     * @param mbArticle 文章信息
     */
    @Override
    public void writeArticleDB(MbArticle mbArticle) {

        Integer row = mbArticleMapper.insertArticle(mbArticle);
//        if (row<=0){
//          后期做数据库没有添加成功，删除文章文件中的文件
//        }
    }

    /**
     * 文章标题失去焦点时查看数据库中的数据
     * @param title 文章标题
     * @return 数据库中返回的查询条数
     */
    @Override
    public Integer articleBytitle(String title) {

        Integer integer = mbArticleMapper.selectMbArticleByTitle(title);

        return integer;
    }

    /**
     * 查询所有的文章信息(分页)
     * @return
     */
    @Override
    public List<MbArticle> articleAllMbArticle(Integer numberPage) {

        List<MbArticle> mbArticles = mbArticleMapper.selectMbArticleByNumber(numberPage);

        System.out.println(mbArticles);

        return mbArticles;
    }

    /**
     * 查询所有的文章(分页)
     * @return
     */
    @Override
    public Paging articleAllPaging(Integer numberPage) {

        Paging pagings = new Paging();

        // 获取文章当前页数的所有文章信息
        List<MbArticle> mbArticles = articleAllMbArticle(numberPage);

        // 获取文章总数
        Integer number = mbArticleMapper.selectPagingByNumber();

        float num = number/7f;
        int numInt = (int)Math.ceil(num);
        Integer numberPages = Integer.valueOf(numInt);

        pagings.setNumberPages(numberPages);
        pagings.setMbArticleList(mbArticles);

        return pagings;
    }

    /**
     * 获取文章地址
     * @return
     */
    @Override
    public String articleToPath(String articleUUID) {

        String articlePath = mbArticleMapper.selectArticleOnUUID(articleUUID);

        return articlePath;
    }

}
