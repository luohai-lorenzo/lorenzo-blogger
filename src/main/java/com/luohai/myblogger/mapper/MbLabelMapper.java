package com.luohai.myblogger.mapper;

import com.luohai.myblogger.domain.MbDistrict;
import com.luohai.myblogger.domain.MbLabel;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @ClassName: MbLabelMapper
 * @Description:
 * @Author: 罗三炮
 * @Date: 2020/5/3 21:25
 **/
@Repository
public interface MbLabelMapper extends Mapper<MbLabel> {

    List<MbDistrict> selectMbDistrictAll();

    List<MbLabel> selectMbLabelAll();

    Integer insertLabelIsText(String labelText);
}
