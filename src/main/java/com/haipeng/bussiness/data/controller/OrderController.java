package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.respository.CompleteOrderRepository;
import com.haipeng.bussiness.data.respository.OrderRepository;
import com.haipeng.bussiness.data.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController{

    public static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderRepository repository;

    // json请求
    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    @ResponseBody
    String getOrders() {

        return "allOrders";
    }


}
