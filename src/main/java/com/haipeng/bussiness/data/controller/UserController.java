package com.haipeng.bussiness.data.controller;

import com.google.gson.Gson;
import com.haipeng.bussiness.data.model.response.ReturnResult;
import com.haipeng.bussiness.data.service.UserService;
import com.haipeng.bussiness.data.model.User;
import com.haipeng.bussiness.data.model.response.ResponseUser;
import com.haipeng.bussiness.data.respository.UserRepository;
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
@RequestMapping("/148124/user")
public class UserController implements UserService {

    public static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    UserService userService = this;

    // json请求
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    ReturnResult addUser(@RequestParam(value = "UserModel", required = true) String json) {
        logger.debug("json", "" + json);
        Gson gosn = new Gson();
        User user = gosn.fromJson(json, User.class);
        userRepository.save(user);
        return ReturnUtils.getResutlt("addUserSuccess","200");
    }

    // json请求
//    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
//    @ResponseBody
//    HashMap<String,Object> queryUser(@RequestParam(value = "UserName", required = true) String userName
//            ,@RequestParam(value = "UserPassword", required = true) String userPassword) {
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("code", "200");
//        hashMap.put("data", convetUserToResponsUser(userRepository.findUserByNameAndPassword(userName,userPassword)));
//        return hashMap;
//    }

    @RequestMapping(value = "/queryUser", method = RequestMethod.POST)
    @ResponseBody
    ResponseUser queryUser(@RequestParam(value = "UserName", required = true) String userName
            ,@RequestParam(value = "UserPassword", required = true) String userPassword) {
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("code", "200");
//        hashMap.put("data", convetUserToResponsUser(userRepository.findUserByNameAndPassword(userName,userPassword)));
        return convetUserToResponsUser(userRepository.findUserByNameAndPassword(userName,userPassword));
    }

    @RequestMapping(value = "/queryUserByUniqueNumber", method = RequestMethod.POST)
    @ResponseBody
    ResponseUser queryUser(@RequestParam(value = "UserUniqueNumber", required = true) long uniqueNumber) {
//        HashMap<String, Object> hashMap = new HashMap<String, Object>();
//        hashMap.put("code", "200");
//        hashMap.put("data", convetUserToResponsUser(userRepository.findUserByNameAndPassword(userName,userPassword)));
        return convetUserToResponsUser(userRepository.findUserUserUniqueNumber(uniqueNumber));
    }

    public ResponseUser convetUserToResponsUser(User user){
        ResponseUser responseUser = new ResponseUser();
        responseUser.setUniqueNumber(user.getUniqueNumber());
        responseUser.setName(user.getName());
        responseUser.setPhone(user.getPhone());
        responseUser.setEmail(user.getEmail());
        responseUser.setAddress(user.getAddress());
        return responseUser;
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
