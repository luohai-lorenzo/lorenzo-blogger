package com.luohai.myblogger.service;

import com.luohai.myblogger.domain.MbDistrict;
import com.luohai.myblogger.domain.MbLabel;

import java.util.List;

public interface MbLabelService {

    /**
     * 查找所有的区域
     * @return
     */
    List<MbDistrict> outDistrict();

    /**
     * 查找所有的标签
     * @return
     */
    List<MbLabel> outLabel();

    /**
     * 插入标签
     * @param labelText
     * @return
     */
    Integer writeLabel(String labelText);

}
