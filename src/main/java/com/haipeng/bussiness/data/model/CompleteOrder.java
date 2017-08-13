package com.haipeng.bussiness.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CompleteOrder {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private long  uniqueNumber; // 唯一编号

    private String userName;

    private String userPhone;

    private String userAdress;

    private String decorationArea;

    private String decorationStyle;

    private String decorationRequire;

    private String masterId;

    private String orderId;

    private String imageUrls;

    private String complementDecorationDescribe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(Long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getDecorationArea() {
        return decorationArea;
    }

    public void setDecorationArea(String decorationArea) {
        this.decorationArea = decorationArea;
    }

    public String getDecorationStyle() {
        return decorationStyle;
    }

    public void setDecorationStyle(String decorationStyle) {
        this.decorationStyle = decorationStyle;
    }

    public String getDecorationRequire() {
        return decorationRequire;
    }

    public void setDecorationRequire(String decorationRequire) {
        this.decorationRequire = decorationRequire;
    }

    public String getMasterId() {
        return masterId;
    }

    public void setMasterId(String masterId) {
        this.masterId = masterId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(String imageUrls) {
        this.imageUrls = imageUrls;
    }

    public String getComplementDecorationDescribe() {
        return complementDecorationDescribe;
    }

    public void setComplementDecorationDescribe(String complementDecorationDescribe) {
        this.complementDecorationDescribe = complementDecorationDescribe;
    }
}
