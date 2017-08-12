package com.haipeng.bussiness.data.controller;


import com.haipeng.bussiness.data.respository.RecommendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/recommend")
public class RecommendController {

    public static Logger logger = LoggerFactory.getLogger(CompleteOrderController.class);

    @Autowired
    RecommendRepository repository;

    // json请求
    @RequestMapping(value = "/getRecommends", method = RequestMethod.GET)
    @ResponseBody
    String getRecommends() {

        return "allRecommends";
    }


}
