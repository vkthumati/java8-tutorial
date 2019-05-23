package com.thumati.java8.concurrency;

public class User {
    private String userId;
    private String userName;
    private Double creditRating;

    public User(String userId, String userName, Double creditRating){
        this.userId = userId;
        this.userName = userName;
        this.creditRating = creditRating;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getCreditRating() {
        return creditRating;
    }

    public void setCreditRating(Double creditRating) {
        this.creditRating = creditRating;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", creditRating=" + creditRating +
                '}';
    }
}
