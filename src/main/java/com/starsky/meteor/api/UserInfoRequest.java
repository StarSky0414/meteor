package com.starsky.meteor.api;

import com.starsky.meteor.controller.login.UserInfoController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserInfoRequest {


    @RequestMapping(value = "/update_info",method = RequestMethod.POST)
    public String userInfoUpdate(@RequestParam(name = "userPhoneNumber")String userPhoneNumber,
                                 @RequestParam(name = "userNickName")String userNickName,
                                 @RequestParam(name = "userPassword")String userPassword){
        System.out.println("userPhoneNumber: "+userPhoneNumber);
        System.out.println("userNickName: "+userNickName);
        System.out.println("userPassword: "+userPassword);
        UserInfoController userInfoController = new UserInfoController();
        if (userInfoController.userInfoUpdate(userPhoneNumber,userNickName,userPassword)){
            return "{\"message\":1}";
        }else {
            System.out.println("验证未通过");
            return "{\"message\":0}";
        }
    }

}
