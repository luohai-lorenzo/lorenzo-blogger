package com.luohai.myblogger.web;

import com.luohai.myblogger.domain.MbNotice;
import com.luohai.myblogger.domain.Paging;
import com.luohai.myblogger.domain.User;
import com.luohai.myblogger.service.MbArticleService;
import com.luohai.myblogger.service.MbNoticeService;
import com.luohai.myblogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName: CategoryController
 * @Description: 登录方面的控制器
 * @Author: 罗三炮
 * @Date: 2020/2/12 14:51
 **/
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private MbNoticeService mbNoticeService;
    @Autowired
    private MbArticleService mbArticleService;

    /**
     * 分页查询网页控制器
     * @param num 页数
     * @return
     */
    @RequestMapping("/paging")
    public String paging(HttpSession httpSession,
                         @RequestParam("num")String num){

        Integer nums;
        Integer numberPage = Integer.valueOf(num);
        Integer Page = Integer.valueOf(num);

        if (num.equals("") || numberPage == 1){
            numberPage = 0;
        };

        if (numberPage == 0){
            nums = numberPage;
        }else{
            nums = numberPage * 7 - 7;
        };

        Paging pagings = mbArticleService.articleAllPaging(nums);

        pagings.setNumberPage(Page);

        httpSession.setAttribute("pagings",pagings);

        return "common/index-message-body";
    };

    /**
     * 获取用户信息，判断登录与否
     * 初始化博客主页
     * @param model
     * @param act 用户账号
     * @param pwd 用户密码
     * @return
     */
    @RequestMapping("/")
    public String index(HttpSession httpSession, Model model, String act, String pwd){
        User user = userService.selectUserForMessage(act,pwd);

        // 获取所有网站公告
        List<MbNotice> mbNoticeList = mbNoticeService.MbNoticeAll();
        // 创建用于传到index页面的公告bean
        MbNotice mbNotices = new MbNotice();
        // 默认公告内容
        mbNotices.setNoticeBody("暂无公告！");
        // 当有公告内容的时候，保存最后一条网站公告用于首页展示
        if (mbNoticeList.size() > 0 ){
            mbNotices = mbNoticeList.get(mbNoticeList.size()-1);
        }

        // 加载页面的时候初始化最新文章动态的列表
        paging(httpSession,"1");

        // 页面接收数据
        model.addAttribute("notices",mbNotices);
        httpSession.setAttribute("userLogin",user); // 用户信息

        System.out.println("用户信息user:" + user);

        /*
         不能去掉，当直接进入网站时user被赋值为null，
         去掉的话下面的user取值会出现空指针异常问题。
        */
        if (user == null){
            return "index";
        };

        if (user.getIsDomain() == 1){
            return "index-manager";
        };

        return "index";
    };

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    };

    /**
     * 跳转注册页面
     * @return
     */
    @RequestMapping("/goRegister")
    public String goRegister() {
        return "register";
    };

    /**
     * 建设的时候跳转页面
     * @return
     */
    @RequestMapping("/demo")
    public String goSprcial(){
        return "demo";
    };

    @RequestMapping("/article")
    public String goArticle(@RequestParam("article")String article){

        System.out.println(article);

        return "article";
    };

    @RequestMapping("/funi")
    public String goFuni(){
        return "funidemo";
    }

};
