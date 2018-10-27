package com.starsky.meteor.controller;

import com.starsky.meteor.controller.test.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping("/testboot")
public class testaaa {
    @RequestMapping("getuser")
    public User getUser() {
        User user = new User();
        user.setName("test");
        return user;
    }
}
