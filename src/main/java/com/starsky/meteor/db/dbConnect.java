package com.starsky.meteor.db;

import org.springframework.jdbc.core.JdbcTemplate;

public class dbConnect {

    private static JdbcTemplate jdbcTemplate;
    static {
        jdbcTemplate = new JdbcTemplate();
    }



}
