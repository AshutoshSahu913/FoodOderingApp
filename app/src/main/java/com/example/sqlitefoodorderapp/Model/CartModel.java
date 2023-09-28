package com.example.sqlitefoodorderapp.Model;

public class CartModel {
    int orderImg;
    String orderFoodName,orderNumber;
    String orderPrice;

    public CartModel() {
    }

    public int getOrderImg() {
        return orderImg;
    }

    public void setOrderImg(int orderImg) {
        this.orderImg = orderImg;
    }

    public String getOrderFoodName() {
        return orderFoodName;
    }

    public void setOrderFoodName(String orderFoodName) {
        this.orderFoodName = orderFoodName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(String orderPrice) {
        this.orderPrice = orderPrice;
    }

}
