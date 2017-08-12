package com.haipeng.bussiness.forum.controller;

import com.haipeng.bussiness.forum.model.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/topic")
public class TopicController {

    @RequestMapping("/topicList")
    @ResponseBody
    public List<Topic> getTopicList(){
        return null;
    }

    @RequestMapping("/topicDetail")
    @ResponseBody
    public Topic getTopicDetail(){
        Topic topic = new Topic();
        return topic;
    }

}
