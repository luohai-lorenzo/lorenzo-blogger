package com.luohai.myblogger.mapper;

import com.luohai.myblogger.domain.MbNotice;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
@Repository
public interface MbNoticeMapper extends Mapper<MbNotice> {

    List<MbNotice> selectMbNoticeAll();

}
