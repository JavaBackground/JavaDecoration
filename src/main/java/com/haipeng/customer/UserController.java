package com.haipeng.customer;

import com.google.gson.Gson;
import com.haipeng.helper.ResponseControllerHelper;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/148124/user")
public class UserController implements UserService {

    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    UserService userService = this;

    // json请求
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    String addSuperUser(@RequestParam(value = "UserModel", required = true) String json) {

//        logger.debug("json", "" + json);
//        Gson gosn = new Gson();
//        User user = gosn.fromJson(json, User.class);
//        userRepository.save(user);
        return "";
    }

    // 返回json,返回所有带密码
//    @GetMapping(path = "/getUserAllRoot")
//    @ResponseBody
//    Iterable<User> getAllSuperUserRoot() {
//        return userRepository.findAll();
//    }

    // 返回json,返回的数据中没有密码比较安全
    @GetMapping(path = "/getUserAll")
    @ResponseBody
    public HashMap<String, Object> getAllSuperUserNew() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", "200");
        hashMap.put("data", userService.getAllSuperUser());
        return hashMap;
    }

    public Iterable<ResponseUser> getAllSuperUser() {

        Iterable<User> superUsers = userRepository.findAll();
        Iterator<User> superUserIterator = superUsers.iterator();

        List<ResponseUser> responseUsers = new ArrayList<ResponseUser>();
        while (superUserIterator.hasNext()) {
            User user = superUserIterator.next();

            ResponseUser responseUser = new ResponseUser();
            responseUser.setName(user.getName());
            responseUser.setEmail(user.getEmail());
            responseUser.setPhone(user.getPhone());

            responseUsers.add(responseUser);
        }

        Iterator<ResponseUser> responseSuperUserIterator = responseUsers.iterator();

        Iterable<ResponseUser> responseSuperUserIterable = new Iterable<ResponseUser>() {
            @Override
            public Iterator<ResponseUser> iterator() {
                return responseSuperUserIterator;
            }
        };

        return responseSuperUserIterable;
    }


}
