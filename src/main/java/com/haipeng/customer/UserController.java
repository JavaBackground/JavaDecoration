package com.haipeng.customer;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    // json请求
    @PostMapping(path = "/addSuperUser")
    @ResponseBody
    String addSuperUser(@RequestParam String json) {
        Gson gosn = new Gson();
        User user = gosn.fromJson(json,User.class);
        userRepository.save(user);
        return "savedSuperUser";
    }

    // 返回json,返回所有带密码
    @GetMapping(path = "/getUserAllRoot")
    @ResponseBody
    Iterable<User> getAllSuperUserRoot() {
        return userRepository.findAll();
    }

    // 返回json,返回的数据中没有密码比较安全
    @GetMapping(path = "/getUserAll")
    @ResponseBody
    Iterable<ResponseUser> getAllSuperUser() {

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
