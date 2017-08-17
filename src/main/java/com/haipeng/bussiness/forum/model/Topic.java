package com.haipeng.bussiness.forum.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private Long  uniqueNumber; // 唯一编号
    private String topicTitle;
    private String topicUserName;
    private String topicImage;
//    private List<TopicFollow> list;

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

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicUserName() {
        return topicUserName;
    }

    public void setTopicUserName(String topicUserName) {
        this.topicUserName = topicUserName;
    }

    public String getTopicImage() {
        return topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }

//    public List<TopicFollow> getList() {
//        return list;
//    }
//
//    public void setList(List<TopicFollow> list) {
//        this.list = list;
//    }
}
