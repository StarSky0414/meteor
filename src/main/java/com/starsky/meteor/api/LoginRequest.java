package com.starsky.meteor.api;


import com.alibaba.fastjson.JSONObject;
import com.starsky.meteor.controller.login.Login;
import com.starsky.meteor.stat.IdentifyingCodeList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginRequest {

    IdentifyingCodeList identifyingCodeList=IdentifyingCodeList.getIdentifyingCodeList();

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginRequest(@RequestParam(name = "phoneNumber")String phoneNumber){
        System.out.println("Request....."+phoneNumber);
        Login login = new Login();
        //{"code":200,"msg":"203","obj":"6755"}
//        String register = login.register(phoneNumber);
        String register="6755";
        JSONObject jsonObject = new JSONObject();
        if (register.equals("")){
            jsonObject.put("message",0);
            jsonObject.put("registerNum","");
        }else {
            identifyingCodeList.addIdentifyingCodeList(phoneNumber,register);
            jsonObject.put("message",1);
            jsonObject.put("registerNum",register);
        }
        String s = jsonObject.toJSONString();
        System.out.println(s);
        return s;
    }

    @RequestMapping(value = "/registernumber",method = RequestMethod.POST)
    public String registerNumber(@RequestParam(name = "phoneNumber")String phoneNumber,
                               @RequestParam(name = "registerNumber")String registerNumber){

        if (identifyingCodeList.findUserIdentifyingCode(phoneNumber,registerNumber)){
            System.out.println("验证通过");
        }else {
            System.out.println("验证未通过");
        }
        System.out.println(phoneNumber);
        System.out.println(registerNumber);
        return "{'message':1}";
    }
}
