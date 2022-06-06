package com.shethap.tech.aws.model;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String name;
    private Integer id;
    private Date registrationDate;
}