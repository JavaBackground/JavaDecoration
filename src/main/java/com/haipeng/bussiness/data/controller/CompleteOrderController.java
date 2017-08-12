package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.response.ResponseUser;
import com.haipeng.bussiness.data.respository.CompleteOrderRepository;
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
@RequestMapping("/order/complete")
public class CompleteOrderController {

    public static Logger logger = LoggerFactory.getLogger(CompleteOrderController.class);

    @Autowired
    CompleteOrderRepository userRepository;

    // json请求
    @RequestMapping(value = "/getCompleteOrders", method = RequestMethod.GET)
    @ResponseBody
    String getCompleteOrders() {
        return "allCompleteOrders";
    }


}
