package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.UserOrder;
import com.haipeng.bussiness.data.model.response.ReturnResult;
import com.haipeng.bussiness.data.respository.UserOrderRepository;
import com.haipeng.utils.constant.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController{

    public static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    UserOrderRepository repository;


    // json请求
    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ResponseBody
    ReturnResult addOrder(@RequestParam(value = "OrderModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        UserOrder model = gosn.fromJson(json, UserOrder.class);
        repository.save(model);
        return ReturnUtils.getResutlt("saveOrderSuccess","200");
    }


    @RequestMapping(value = "/getOrderByOrderUniqueNumber", method = RequestMethod.POST)
    @ResponseBody
    UserOrder getOrderByUniqueNumber(@RequestParam(value = "OrderUniqueNumber", required = true) long uniquNumber) {
        UserOrder order = new UserOrder();
        order = repository.getOrderByUniqueNumber(uniquNumber);
        return order;
    }

    @RequestMapping(value = "/getOrdersByUserUniqueNumber", method = RequestMethod.POST)
    @ResponseBody
    List<UserOrder> getOrdersByUserUniqueNumber(@RequestParam(value = "UserUniqueNumber", required = true) long userUniqueNumber) {
        List<UserOrder> orders = new ArrayList<UserOrder>();
        orders = repository.getOrdersByUserUniqueNumnber(userUniqueNumber);
        return orders;
    }


    // 返回json,返回所有带密码
//    @GetMapping(path = "/getUserAllRoot")
//    @ResponseBody
//    Iterable<User> getAllSuperUserRoot() {
//        return userRepository.findAll();
//    }

    // 返回json,返回的数据中没有密码比较安全
    //TODO 做一次放回10个，等展示完全软件能用的时候添加这个功能
    @GetMapping(path = "/getAllOrder")
    @ResponseBody
    public HashMap<String, Object> getAllOrder() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", "200");
        hashMap.put("data", repository.findAll());
        return hashMap;
    }


}
