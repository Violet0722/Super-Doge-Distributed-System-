package com.nike.models;

public class Order {

    private int orderId;
    private int memberId;
    private String deliveryCompany;
    private String deliveryTime;
    private String productName;
    private int costPoints;

    public Order(int orderId, int memberId, String deliveryCompany, String deliveryTime, String productName, int costPoints) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.deliveryCompany = deliveryCompany;
        this.deliveryTime = deliveryTime;
        this.productName = productName;
        this.costPoints = costPoints;
    }

    public Order() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getDeliveryCompany() {
        return deliveryCompany;
    }

    public void setDeliveryCompany(String deliveryCompany) {
        this.deliveryCompany = deliveryCompany;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCostPoints() {
        return costPoints;
    }

    public void setCostPoints(int costPoints) {
        this.costPoints = costPoints;
    }
}
