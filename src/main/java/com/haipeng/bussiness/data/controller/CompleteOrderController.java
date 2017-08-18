package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.model.response.ReturnResult;
import com.haipeng.bussiness.data.respository.CompleteOrderRepository;
import com.haipeng.utils.constant.ReturnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order/complete")
public class CompleteOrderController {

    public static Logger logger = LoggerFactory.getLogger(CompleteOrderController.class);

    @Autowired
    CompleteOrderRepository userRepository;

    // json请求
    @RequestMapping(value = "/getCompleteOrders", method = RequestMethod.GET)
    @ResponseBody
    ReturnResult getCompleteOrders() {
        return ReturnUtils.getResutlt("allCompleteOrders","200");
    }


}
