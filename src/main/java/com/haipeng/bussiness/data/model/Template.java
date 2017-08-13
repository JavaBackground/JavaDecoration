package com.haipeng.bussiness.data.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class ,auto create table;
public class Template {   // 推荐风格
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private long uniqueNumber;

    private String title;

    private String masterUniqueNumber;

    private String vendorUniqueNumber;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMasterUniqueNumber() {
        return masterUniqueNumber;
    }

    public void setMasterUniqueNumber(String masterUniqueNumber) {
        this.masterUniqueNumber = masterUniqueNumber;
    }

    public String getVendorUniqueNumber() {
        return vendorUniqueNumber;
    }

    public void setVendorUniqueNumber(String vendorUniqueNumber) {
        this.vendorUniqueNumber = vendorUniqueNumber;
    }

    public String getImageAvator() {
        return imageAvator;
    }

    public void setImageAvator(String imageAvator) {
        this.imageAvator = imageAvator;
    }
}