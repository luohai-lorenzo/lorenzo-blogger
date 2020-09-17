package com.luohai.myblogger.mapper;

import com.luohai.myblogger.domain.MbArticle;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface MbArticleMapper extends Mapper<MbArticle> {

    Integer insertArticle(MbArticle mbArticle);

    Integer selectMbArticleByTitle(@Param("title")String title);

    Integer selectPagingByNumber();

    List<MbArticle> selectMbArticleByNumber(@Param("numberPage")Integer numberPage);

    String selectArticleOnUUID(@Param("articleUUID")String articleUUID);
}
