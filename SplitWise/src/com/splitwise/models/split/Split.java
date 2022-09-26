package com.splitwise.models.split;

import com.splitwise.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Split {

    private User user;
    double amount;

    public Split(User user) {
        this.user = user;
    }
}
