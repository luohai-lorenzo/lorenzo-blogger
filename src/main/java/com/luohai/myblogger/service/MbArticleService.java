package com.luohai.myblogger.service;

import com.luohai.myblogger.domain.MbArticle;
import com.luohai.myblogger.domain.Paging;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface MbArticleService {

    void writeArticleDB(MbArticle mbArticle);

    Integer articleBytitle(String title);

    /**
     * 查看所有的文章（分页）
     * @param numberPage
     * @return
     */
    Paging articleAllPaging(Integer numberPage);

    List<MbArticle> articleAllMbArticle(Integer numberPage);

    String articleToPath(String articleUUID);


}
