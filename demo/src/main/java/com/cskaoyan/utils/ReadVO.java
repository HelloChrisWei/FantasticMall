package com.cskaoyan.utils;

public class ReadVO<T> {

    private ResultVO<T> data;

    private String errmsg;

    private int errno;

    public ResultVO<T> getData() {
        return data;
    }

    public void setData(ResultVO<T> data) {
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
