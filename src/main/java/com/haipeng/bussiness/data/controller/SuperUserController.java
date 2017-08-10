package com.haipeng.bussiness.data.controller;

import com.haipeng.bussiness.data.model.SuperUser;
import com.haipeng.bussiness.data.model.response.ResponseSuperUser;
import com.haipeng.bussiness.data.respository.SuperUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/user")
public class SuperUserController {

    @Autowired
    SuperUserRepository superUserRepository;

    // json请求
    @PostMapping(path = "/addSuperUser")
    @ResponseBody
    String addSuperUser(@RequestBody SuperUser superUser) {
        superUserRepository.save(superUser);
        return "savedSuperUser";
    }

    // 返回json
    @GetMapping(path = "/getSuperUserAllRoot")
    @ResponseBody
    Iterable<SuperUser> getAllSuperUserRoot() {
        return superUserRepository.findAll();
    }

    // 返回json
    @GetMapping(path = "/getSuperUserAll")
    @ResponseBody
    Iterable<ResponseSuperUser> getAllSuperUser() {

        Iterable<SuperUser> superUsers = superUserRepository.findAll();
        Iterator<SuperUser> superUserIterator = superUsers.iterator();

        List<ResponseSuperUser> responseSuperUsers = new ArrayList<ResponseSuperUser>();
        while (superUserIterator.hasNext()) {
            SuperUser superUser = superUserIterator.next();

            ResponseSuperUser responseSuperUser = new ResponseSuperUser();
            responseSuperUser.setName(superUser.getName());
            responseSuperUser.setEmail(superUser.getEmail());
            responseSuperUser.setPhone(superUser.getPhone());

            responseSuperUsers.add(responseSuperUser);
        }

        Iterator<ResponseSuperUser> responseSuperUserIterator = responseSuperUsers.iterator();

        Iterable<ResponseSuperUser> responseSuperUserIterable = new Iterable<ResponseSuperUser>() {
            @Override
            public Iterator<ResponseSuperUser> iterator() {
                return responseSuperUserIterator;
            }
        };

        return responseSuperUserIterable;
    }


}
