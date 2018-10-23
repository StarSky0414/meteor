package com.starsky.meteor;

import com.starsky.meteor.api.MessageInfoACKRequest;
import com.starsky.meteor.db.HibernateFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.io.IOException;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MeteorApplication {
    public static void main(String[] args) {

        SpringApplication.run(MeteorApplication.class, args);
        initServer();

    }

    private static void initServer(){
        try {
            MessageInfoACKRequest messageInfoACKRequest = new MessageInfoACKRequest();
//            messageInfoACKRequest.getHeartJumpPack();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
