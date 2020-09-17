package com.luohai.myblogger.web;

import com.luohai.myblogger.domain.MbNotice;
import com.luohai.myblogger.service.MbNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName: MbNoticeController
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/3/3 20:33
 **/
@Controller
public class MbNoticeController {

    @Autowired
    MbNoticeService mbNoticeService;

}
