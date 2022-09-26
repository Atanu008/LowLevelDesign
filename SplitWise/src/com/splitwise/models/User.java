package com.splitwise.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private int userId;
    private String userName;
    private String email;
    private String mobileNumber;

}
