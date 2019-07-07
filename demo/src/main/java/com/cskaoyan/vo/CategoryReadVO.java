package com.cskaoyan.vo;


import java.util.List;

public class CategoryReadVO<T> {

    private List<CategoryVO> data;

    private String errmsg;

    private int errno;

    public List<CategoryVO> getData() {
        return data;
    }

    public void setData(List<CategoryVO> data) {
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
