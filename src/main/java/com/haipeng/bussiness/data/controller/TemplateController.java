package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.Master;
import com.haipeng.bussiness.data.model.Template;
import com.haipeng.bussiness.data.respository.MasterRepository;
import com.haipeng.bussiness.data.respository.TemplateRepository;
import com.haipeng.utils.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


@Controller
@RequestMapping("/template")
public class TemplateController {

    public static Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    TemplateRepository repository;

    // json请求
    @RequestMapping(value = "/addTemplate", method = RequestMethod.POST)
    @ResponseBody
    String addTemplate(@RequestParam(value = "TemplateModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        Template model = gosn.fromJson(json, Template.class);
        repository.save(model);
        return ReturnUtils.success("saveTemplateSuccess");
    }

    // 返回json,返回所有带密码
//    @GetMapping(path = "/getUserAllRoot")
//    @ResponseBody
//    Iterable<User> getAllSuperUserRoot() {
//        return userRepository.findAll();
//    }

    // 返回json,返回的数据中没有密码比较安全
    //TODO 做一次放回10个，等展示完全软件能用的时候添加这个功能
    @GetMapping(path = "/getAllTemplate")
    @ResponseBody
    public HashMap<String, Object> getAllTemplate() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", "200");
        hashMap.put("data", repository.findAll());
        return hashMap;
    }

}
