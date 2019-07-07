package com.cskaoyan.vo;

public class GoodsPreviewVO {
    String errmsg;
    int errno;
    Object data;

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public GoodsPreviewVO() {
    }

    public GoodsPreviewVO(String errmsg, int errno, Object data) {
        this.errmsg = errmsg;
        this.errno = errno;
        this.data = data;
    }
}
