package com.haipeng.bussiness.data.controller;


import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.Recommend;
import com.haipeng.bussiness.data.model.response.ReturnResult;
import com.haipeng.bussiness.data.respository.RecommendRepository;
import com.haipeng.utils.constant.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Controller
@RequestMapping("/recommend")
public class RecommendController {

    public static Logger logger = LoggerFactory.getLogger(CompleteOrderController.class);

    @Autowired
    RecommendRepository repository;

    // json请求
    @RequestMapping(value = "/addRecommend", method = RequestMethod.POST)
    @ResponseBody
    ReturnResult addRecommend(@RequestParam(value = "RecommendModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        Recommend model = gosn.fromJson(json, Recommend.class);
        repository.save(model);
        return ReturnUtils.getResutlt("saveRecommendSuccess", "200");
    }

    @RequestMapping(value = "/queryRecommendByUniqueNumber", method = RequestMethod.POST)
    @ResponseBody
    Recommend queryRecommend(@RequestParam(value = "RecommendUniqueNumber", required = true) long uniqueNumber) {

        logger.debug("RecommendUniqueNumber", "" + uniqueNumber);
        return repository.getRecommendByUniqueNumber(uniqueNumber);
    }

    @GetMapping(path = "/queryAllRecommend")
    @ResponseBody
    public List<Recommend> getAllRecommend() {

        List<Recommend> list = new ArrayList<Recommend>();
        Iterator<Recommend> iterator = repository.findAll().iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }


}
