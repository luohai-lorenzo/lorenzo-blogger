package com.luohai.myblogger.domain;

import java.io.Serializable;
/**
 * @ClassName: WangEditor
 * @Description: 富文本编辑器数据实体类
 * @Author: 罗三炮
 * @Date: 2020/8/15 21:07
 **/
public class WangEditor implements Serializable {

    private Integer errno; // 错误代码，0 表示没错误

    private String url; // 已上传图片的路径

    public WangEditor(String url) {
        super();
        this.errno = 0;
        this.url = url;
    }

    public Integer getErrno() {
        return errno;
    }

    public void setErrno(Integer errno) {
        this.errno = errno;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
