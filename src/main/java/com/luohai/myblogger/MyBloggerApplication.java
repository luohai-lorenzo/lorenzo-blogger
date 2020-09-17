package com.luohai.myblogger;

import com.luohai.myblogger.util.SubsidiaryTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = {"com.luohai.myblogger.mapper"})
public class MyBloggerApplication {

    public static void main(String[] args) {
        // 查看是否存在博客文件夹，如果不存在则创建
        SubsidiaryTool.Tool.createFile();
        SpringApplication.run(MyBloggerApplication.class, args);
    }

}
