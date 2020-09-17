package com.luohai.myblogger.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.UUID;

/**
 * @ClassName: SubsidiaryTool
 * @Description: 用于创建一些附属工具的类
 * @Author: 罗三炮
 * @Date: 2020/4/8 16:24
 **/
@Component
public class SubsidiaryTool {

    /**
     * 创建一个不重复的UUID
     * @return
     */
    public String createUUID(){
        String u = UUID.randomUUID().toString();
        u = u.toUpperCase();// 转换大小写

        return u;
    }

    /**
     * 创建一个静态工具内部类，
     * 作为公用方法
     */
    public static class Tool{

        /**
         * 获取项目绝对路径的工具
         * @return 返回的是该项目所在的一个文件夹路径
         */
        public static String getPath() {

            File dire = new File("");

            String paths = dire.getAbsolutePath();

            StringBuffer stringBuffer = new StringBuffer(paths);

            StringBuffer stringBufferRecerse = stringBuffer.reverse();

            StringBuffer bufferCopy = new StringBuffer();

            for (int i = 0;i < stringBufferRecerse.length();i++){

                if (stringBufferRecerse.charAt(i) == '\\'){
                    break;
                }
                bufferCopy.append(stringBufferRecerse.charAt(i));
            }

            stringBufferRecerse.delete(0,bufferCopy.length());

            String truthPath = stringBufferRecerse.reverse().toString();

            return truthPath;
        };

        /**
         * 判断项目路径下有无博客存放文件的文件夹路径BlogsFile，如果有则不创建，
         * 如果没有则自动创建，该方法需在启动的时候自动运行
         */
        public static void createFile() {
            // 获取项目的相对路径
            String path = SubsidiaryTool.Tool.getPath();
            // 创建自适应分隔符
            String fileSeperator = File.separator;

            // 文件夹名字
            String fileBlogsName = "BlogsFile";
            String fileImageName = fileSeperator + "BlogsImage";
            String fileArticleName = fileSeperator + "BlogsArticle";
            String fileArticleImageName = fileSeperator + "BlogsArticleImage";

            File file = new File(path + fileBlogsName);

            // 判断该路径下是否存在文件夹，如果不存在就创建
            if (!file.exists()){
                System.out.println("博客所需文件夹不存在，已自动创建！");
                // 创建博客总文件夹
                file.mkdirs();

                // 创建博客照片文件夹
                File file1 = new File(path + fileBlogsName + fileImageName);
                file1.mkdir();

                // 创建博客文章文件夹
                File file2 = new File(path + fileBlogsName + fileArticleName);
                file2.mkdir();

                // 创建博客文章图片文件夹
                File file3 = new File(path + fileBlogsName + fileArticleImageName);
                file3.mkdir();
            }
        }

        public static void copyInputStreamToFile(){




        }



    }


}
