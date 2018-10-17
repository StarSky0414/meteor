package com.starsky.meteor;

import com.starsky.meteor.db.HibernateFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MeteorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MeteorApplication.class, args);
    }
}
