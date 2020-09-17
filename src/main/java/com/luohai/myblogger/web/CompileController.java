package com.luohai.myblogger.web;

import com.luohai.myblogger.domain.MbArticle;
import com.luohai.myblogger.domain.MbLabel;
import com.luohai.myblogger.domain.WangEditor;
import com.luohai.myblogger.service.MbArticleService;
import com.luohai.myblogger.service.MbLabelService;
import com.luohai.myblogger.util.ArticleFactory;
import com.luohai.myblogger.util.EnumPath;
import com.luohai.myblogger.util.SubsidiaryTool;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * @ClassName: CompileController
 * @Description: 编辑文章控制器
 * @Author: 罗三炮
 * @Date: 2020/2/26 13:09
 **/

@Controller
public class CompileController {

    @Autowired
    ArticleFactory articleFactory;
    @Autowired
    MbArticleService mbArticleService;
    @Autowired
    MbLabelService mbLabelService;

    /**
     * 写文章页面加载的时候同时加载的文章所有区域和标签信息
     * @return
     */
    @RequestMapping("/write")
    public String write(){
        return "writeArticles";
    }

    /**
     * 确定创建新的文章
     * @param title 文章标题
     * @param htmlContent 文章html内容
     * @param district 文章的区域ID
     * @param label 文章的标签ID
     * @return
     */
    @ResponseBody
    @RequestMapping("/writeFile")
    public String writeFile(@RequestParam("title")String title,
                            @RequestParam("htmlContent")String htmlContent,
                            @RequestParam("district")String district,
                            @RequestParam("label")String label){

        // 文章相关信息创建并且写入文件夹
        String path = articleFactory.write(title,htmlContent);

        String[] labelArray = label.split(",");

        File file = new File(path);

        SubsidiaryTool subsidiaryTool = new SubsidiaryTool();

        String a = subsidiaryTool.createUUID();

        if (file.exists()){
            MbArticle mbArticle = new MbArticle();
            mbArticle.setUuid(subsidiaryTool.createUUID());
            mbArticle.setTitle(title);
            mbArticle.setEssayAddress(path);
            mbArticle.setDistrict(district);
            mbArticle.setLabel(label);
            // 文章插入数据库
            mbArticleService.writeArticleDB(mbArticle);
        }else{
            return "error";
        }

        List<MbLabel> mbLabelList =  mbLabelService.outLabel();
        // 判断数据库中是否存在相同的标签，如果没有就插入
        // 当数据表为空的时候for循环List不会进行，所以需要一个判断
        if (mbLabelList.size() != 0){
            for (int i = 0;i<labelArray.length;i++){
                for (MbLabel mbLabel : mbLabelList){
                    if (labelArray[i] != mbLabel.getLabelText()){
                        mbLabelService.writeLabel(labelArray[i]);
                    }
                }
            }
        }else {
            for (int i = 0;i<labelArray.length;i++){
                mbLabelService.writeLabel(labelArray[i]);
            }
        }
        return "succeed";
    }

    /**
     *  文章标题失去焦点判断
     * @param title 传入的文章标题
     * @return
     */
    @ResponseBody
    @RequestMapping("/titleMethod")
    public String titleMethod(String title){

        Integer number = mbArticleService.articleBytitle(title);

        if (number == 1){
            // 文章标题存在
            return "success1";
        }
        // 文章标题不存在
        return "success2";
    };

    /**
     * 富文本编辑器处理图片上传问题
     * @param myFile
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFile")
    public WangEditor uploadFile(@RequestParam(value = "myFile",required = true)MultipartFile myFile){

        String fileName = myFile.getOriginalFilename();

        // 创建自适应分隔符
        String fileSeperator = File.separator;

        // 文章图片存放路径
        String path = SubsidiaryTool.Tool.getPath() + EnumPath.BlogsFile + fileSeperator + EnumPath.BlogsArticleImage + fileSeperator;

        try {

            File file = new File(path,fileName);

            // 文件存入流中
            InputStream inputStream = myFile.getInputStream();

            FileUtils.copyInputStreamToFile(inputStream,file);

            WangEditor wangEditor = new WangEditor("/FileImages/" + fileName);

            return wangEditor;

        }catch (IOException e){
            System.out.println("上传失败！");
        }

    return null;
    };

    /**
     *
     * @param articleUUID
     * @return
     * @throws Exception
     */
    @ResponseBody
    @RequestMapping("/readCompile")
    public String readCompile(@RequestParam(value = "articleUUID",required = true) String articleUUID) throws Exception{

        String titlePath = mbArticleService.articleToPath(articleUUID);

        System.out.println(titlePath);

        String show = articleFactory.show(titlePath);

        return show;
    }

}
