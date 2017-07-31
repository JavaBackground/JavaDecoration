package com.haipeng.data;

import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/mobile")
public class MobileUploadTokenController {

//    @Autowired

    @GetMapping(path = "/token")
    public @ResponseBody
    String getToken() {
        String accessKey = "KJ2OacWHzdXzqviuSrlZ3n4RX_q9wXzTTekjnfMt";
        String secretKey = "JxfBgouHFg5d2aARgLD91OeFbQSwQ6ubuwXfUjFm";
        String bucket = "decoration";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        return upToken;
    }

//    @Autowired // This means to get the bean called userRepository
//    // Which is auto-generated by Spring, we will use it to handle the data
//    private UserRepository userRepository;

//    @GetMapping(path = "/add") // Map ONLY GET Requests
//    public @ResponseBody
//    String addNewUser(@RequestParam String name
//            , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

//        User n = new User();
//        n.setName(name);
//        n.setEmail(email);
//        userRepository.save(n);
//        return "Saved";
//    }

//    @GetMapping(path = "/all")
//    public @ResponseBody
//    Iterable<User> getAllUsers() {
//        // This returns a JSON or XML with the users
//        return userRepository.findAll();
//    }

    @GetMapping(path = "/ss")
    public @ResponseBody
    String getSuccess() {
        return "success";
    }
}