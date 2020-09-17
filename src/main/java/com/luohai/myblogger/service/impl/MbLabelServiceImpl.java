package com.luohai.myblogger.service.impl;

import com.luohai.myblogger.domain.MbDistrict;
import com.luohai.myblogger.domain.MbLabel;
import com.luohai.myblogger.mapper.MbLabelMapper;
import com.luohai.myblogger.service.MbLabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: MbLabelServiceImpl
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 21:22
 **/
@Service
public class MbLabelServiceImpl implements MbLabelService {

    @Autowired
    MbLabelMapper mbLabelMapper;

    @Override
    public List<MbDistrict> outDistrict() {
        return mbLabelMapper.selectMbDistrictAll();
    }

    @Override
    public List<MbLabel> outLabel() {
        return mbLabelMapper.selectMbLabelAll();
    }

    @Override
    public Integer writeLabel(String labelText) {

        System.out.println(labelText);

        Integer number = mbLabelMapper.insertLabelIsText(labelText);

        return number;
    }
}
