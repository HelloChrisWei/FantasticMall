package com.cskaoyan.vo;

import java.util.List;

public class L1MapVO {
    List Date;

    String errmsg;

    int errno;

    public List getDate() {
        return Date;
    }

    public void setDate(List date) {
        Date = date;
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
