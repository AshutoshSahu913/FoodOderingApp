package com.example.sqlitefoodorderapp.Model;

public class FoodModel {
    int foodImg;
    String foodName,foodDes;
    String foodPrice;
    String userName,uPhoneNo;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setuPhoneNo(String uPhoneNo) {
        this.uPhoneNo = uPhoneNo;
    }

    public int getFoodImg() {
        return foodImg;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public FoodModel(int foodImg, String foodName, String foodDes, String  foodPrice) {
        this.foodImg = foodImg;
        this.foodName = foodName;
        this.foodDes = foodDes;
        this.foodPrice = foodPrice;
    }
}
