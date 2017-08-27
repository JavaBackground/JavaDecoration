package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.Vendor;
import com.haipeng.bussiness.data.model.response.ReturnResult;
import com.haipeng.bussiness.data.respository.VendorRepository;
import com.haipeng.utils.constant.ReturnUtils;
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
@RequestMapping("/vendor")
public class VendorController {

    public static Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    VendorRepository repository;


    // json请求
    @RequestMapping(value = "/addVendor", method = RequestMethod.POST)
    @ResponseBody
    ReturnResult addMaster(@RequestParam(value = "VendorModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        Vendor model = gosn.fromJson(json, Vendor.class);
        repository.save(model);
        return ReturnUtils.getResutlt("saveVendorSuccess", "200");
    }

    @RequestMapping(value = "/queryVendorByUniqueNumber", method = RequestMethod.POST)
    @ResponseBody
    Vendor queryVendor(@RequestParam(value = "VendorUniqueNumber", required = true) long uniqueNumber) {

        logger.debug("VendorUniqueNumber", "" + uniqueNumber);

        if (null == repository.getVendorByUniqueNumber(uniqueNumber)) {
            return new Vendor();
        } else {
            return repository.getVendorByUniqueNumber(uniqueNumber);
        }
    }

    @GetMapping(path = "/queryAllVendor")
    @ResponseBody
    public List<Vendor> getAllVendor() {

        List<Vendor> list = new ArrayList<Vendor>();
        Iterator<Vendor> iterator = repository.findAll().iterator();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    // 返回json,返回所有带密码
//    @GetMapping(path = "/getUserAllRoot")
//    @ResponseBody
//    Iterable<User> getAllSuperUserRoot() {
//        return userRepository.findAll();
//    }

    // 返回json,返回的数据中没有密码比较安全
    //TODO 做一次放回10个，等展示完全软件能用的时候添加这个功能
//    @GetMapping(path = "/getAllVendor")
//    @ResponseBody
//    public HashMap<String, Object> getAllVendor() {
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("code", "200");
//        hashMap.put("data", repository.findAll());
//        return hashMap;
//    }


}
