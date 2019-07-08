package com.cskaoyan.vo;

public class OrderVO {
    private OrderDetailVO data;

    private String errmsg;

    private int errno;

    public OrderDetailVO getData() {
        return data;
    }

    public void setData(OrderDetailVO data) {
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
