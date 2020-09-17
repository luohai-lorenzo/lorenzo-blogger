package com.luohai.myblogger.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtilController {

    /**
     * 账号创建成功后中转页面
     * @param title
     * @param targetTitle
     * @param urls
     * @param model
     * @return
     */
    @RequestMapping("/middle")
    public String middle(String title, String targetTitle, String urls, Model model){

        // 页面接收数据
        model.addAttribute("title",title);
        model.addAttribute("targetTitle",targetTitle);
        model.addAttribute("urls",urls);

        return "common/middle";
    }

}
