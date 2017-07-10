package com.xieyunhai.entity;

import java.util.Date;

public class Customer extends User {

    private Integer userId;
    private Integer managerId;
    private Integer points;
    private String invoiceTitle;
    private String shopName;
    private Short userSource;
    private Short userLevel;
    private Integer referee;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public Short getUserSource() {
        return userSource;
    }

    public void setUserSource(Short userSource) {
        this.userSource = userSource;
    }

    public Short getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Short userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getReferee() {
        return referee;
    }

    public void setReferee(Integer referee) {
        this.referee = referee;
    }

    @Override
    public Date getCreateTime() {
        return super.getCreateTime();
    }

    @Override
    public void setCreateTime(Date createTime) {
        super.setCreateTime(createTime);
    }

    @Override
    public Date getUpdateTime() {
        return super.getUpdateTime();
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        super.setUpdateTime(updateTime);
    }

}