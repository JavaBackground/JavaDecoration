package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.respository.TemplateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/template")
public class TemplateController {

    public static Logger logger = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    TemplateRepository repository;

    // json请求
    @RequestMapping(value = "/getTemplates", method = RequestMethod.GET)
    @ResponseBody
    String getTemplates() {

        return "allTemplates";
    }


}
