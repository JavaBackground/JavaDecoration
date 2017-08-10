package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserShamController {

//    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    // json请求
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    String addSuperUser(@RequestParam(value = "UserModel", required = true) String json) {

        return "";
    }

    // 返回json,返回所有带密码
    @GetMapping(path = "/getUserAllRoot")
    @ResponseBody
    String getAllSuperUserRoot() {
        return "";
    }

    // 返回json,返回的数据中没有密码比较安全
    @GetMapping(path = "/getUserAll")
    @ResponseBody
    String getAllSuperUser() {
        return "";
    }
}

