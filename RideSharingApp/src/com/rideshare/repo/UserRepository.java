package com.rideshare.repo;

import com.rideshare.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserRepository {

    private List<User> allUsers;

    public UserRepository(){
        allUsers = new ArrayList<>();
    }

}
