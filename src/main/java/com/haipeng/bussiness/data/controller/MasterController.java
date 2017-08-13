package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.Master;
import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.response.ResponseUser;
import com.haipeng.bussiness.data.respository.CompleteOrderRepository;
import com.haipeng.bussiness.data.respository.MasterRepository;
import com.haipeng.bussiness.data.respository.UserRepository;
import com.haipeng.bussiness.data.service.UserService;
import com.haipeng.utils.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/master")
public class MasterController {

    public static Logger logger = LoggerFactory.getLogger(MasterController.class);

    @Autowired
    MasterRepository repository;

    // json请求
    @RequestMapping(value = "/addMaster", method = RequestMethod.POST)
    @ResponseBody
    String addMaster(@RequestParam(value = "MasterModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        Master model = gosn.fromJson(json, Master.class);
        repository.save(model);
        return ReturnUtils.success("saveMasterSuccess");
    }

    // 返回json,返回所有带密码
//    @GetMapping(path = "/getUserAllRoot")
//    @ResponseBody
//    Iterable<User> getAllSuperUserRoot() {
//        return userRepository.findAll();
//    }

    // 返回json,返回的数据中没有密码比较安全
    //TODO 做一次放回10个，等展示完全软件能用的时候添加这个功能
    @GetMapping(path = "/getAllMaster")
    @ResponseBody
    public HashMap<String, Object> getAllMaster() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", "200");
        hashMap.put("data", repository.findAll());
        return hashMap;
    }

}
