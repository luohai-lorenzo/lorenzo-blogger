package com.luohai.myblogger.util;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.*;

/**
 * @ClassName: ArticleFactory
 * @Description: 控制文章的写入、展示工厂
 * @Author: 罗三炮
 * @Date: 2020/3/4 0:24
 **/
@Component
public class ArticleFactory {

    // 获得项目所需的所在路径
    final String path = SubsidiaryTool.Tool.getPath();

    /**
     * 文章的创建和写入内容
     * @param pathName 文章标题
     * @param articleContent 文章内容
     * @throws IOException
     */
    public String write(@Param("title") String pathName,@Param("htmlContent") String articleContent){

        // 合并文章路径
        String pathNames = path + EnumPath.BlogsFile + "\\" + EnumPath.BlogsArticle + "\\" + pathName + ".txt";

        // 创建、合并过后的文章txt文件,如果该txt存在的话就不会创建而是直接覆盖
        File file = new File(pathNames);
        try{
            // 开启file流
            FileOutputStream out = new FileOutputStream(file);
            // 文章内容放入字节类中
            byte text[] = articleContent.getBytes();
            // 将文章内容写入文章txt文件
            out.write(text);
            // 关闭file流
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        };

        return pathNames;
    };

    /**
     * 文章的读取展示
     * @return
     */
    public String show(@Param("articlePath") String path) throws IOException {

        InputStream input = new FileInputStream(path);

        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        StringBuffer buffer = new StringBuffer();

        String line = "";

        while ((line = reader.readLine()) != null){
            buffer.append(line);
        }

        return buffer.toString();
    }

};
