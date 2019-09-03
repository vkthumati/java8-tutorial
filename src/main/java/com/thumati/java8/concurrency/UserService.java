package com.thumati.java8.concurrency;

public class UserService {

    public User getUserDetails(String userId){
        return new User(userId, "Vasantha Kumar Thumati", 750.0);
    }

}
