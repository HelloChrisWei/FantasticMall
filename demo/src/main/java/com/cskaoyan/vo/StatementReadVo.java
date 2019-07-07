package com.cskaoyan.vo;

public class StatementReadVo<T> {
    private StatementResultVo<T> data;

    private String errmsg;

    public StatementResultVo<T> getData() {
        return data;
    }

    public void setData(StatementResultVo<T> data) {
        this.data = data;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    private String errno;
}
