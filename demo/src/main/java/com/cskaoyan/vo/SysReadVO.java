package com.cskaoyan.vo;

public class SysReadVO {

    private SysResultVO data;

    private String errmsg;

    private int errno;

    public SysResultVO getData() {
        return data;
    }

    public void setData(SysResultVO data) {
        this.data = data;
    }

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
}
