package com.luohai.myblogger.service.impl;

import com.luohai.myblogger.domain.MbNotice;
import com.luohai.myblogger.mapper.MbNoticeMapper;
import com.luohai.myblogger.service.MbNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MbNoticeImpl
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/3/3 20:29
 **/
@Service
public class MbNoticeImpl implements MbNoticeService {

    @Autowired
    MbNoticeMapper mbNoticeMapper;

    @Override
    public List<MbNotice> MbNoticeAll() {

        List<MbNotice> mbNotices = mbNoticeMapper.selectMbNoticeAll();

        return mbNotices;
    }



}
