package com.haipeng.bussiness.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private long  uniqueNumber; // 唯一编号

    private long  userUniqueNumber;

    private String userName;

    private String userPhone;

    private String userAdress;

    private String userEmail;

    private String decorationArea;

    private String decorationStyle;

    private String decorationRequire;

    private String imageAvator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getUniqueNumber() {
        return uniqueNumber;
    }

    public void setUniqueNumber(long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public long getUserUniqueNumber() {
        return userUniqueNumber;
    }

    public void setUserUniqueNumber(long userUniqueNumber) {
        this.userUniqueNumber = userUniqueNumber;
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

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    public String getImageAvator() {
        return imageAvator;
    }

    public void setImageAvator(String imageAvator) {
        this.imageAvator = imageAvator;
    }
}
