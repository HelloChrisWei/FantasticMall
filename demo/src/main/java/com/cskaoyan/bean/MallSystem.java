package com.cskaoyan.bean;

import java.util.Date;

public class MallSystem {
    private String keyName;
    private String keyValue;
    private Date addTime;
    private Date updateTime;
    private int deleted;

    public MallSystem(String keyname, String keyValue, Date addTime, Date updateTime, int deleted) {
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.addTime = addTime;
        this.updateTime = updateTime;
        this.deleted = deleted;
    }

    public MallSystem() {
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyname) {
        this.keyName = keyname;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }
}
