package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.respository.VendorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/vendor")
public class VendorController{

    public static Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    VendorRepository repository;

    // json请求
    @RequestMapping(value = "/getVendors", method = RequestMethod.GET)
    @ResponseBody
    String getVendors() {

        return "allVendors";
    }


}
