package com.splitwise.service;

import com.splitwise.group.Group;
import com.splitwise.models.User;

public class UserService {

    Group group;

    public UserService(Group group){
        this.group = group;
    }

    public void addUser(User user){
        group.addUser(user);
    }

    public User getUser(String userName){
        return group.getUser(userName);
    }
}
