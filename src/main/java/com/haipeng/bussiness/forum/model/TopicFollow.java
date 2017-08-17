package com.haipeng.bussiness.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TopicFollow {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private long  uniqueNumber; // 唯一编号
    private String followTitle;
    private String followUserName;
    private String followImage;
    private long   topicUniqueNumber;

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

    public String getFollowTitle() {
        return followTitle;
    }

    public void setFollowTitle(String followTitle) {
        this.followTitle = followTitle;
    }

    public String getFollowUserName() {
        return followUserName;
    }

    public void setFollowUserName(String followUserName) {
        this.followUserName = followUserName;
    }

    public String getFollowImage() {
        return followImage;
    }

    public void setFollowImage(String followImage) {
        this.followImage = followImage;
    }

    public void setUniqueNumber(long uniqueNumber) {
        this.uniqueNumber = uniqueNumber;
    }

    public long getTopicUniqueNumber() {
        return topicUniqueNumber;
    }

    public void setTopicUniqueNumber(long topicUniqueNumber) {
        this.topicUniqueNumber = topicUniqueNumber;
    }
}
