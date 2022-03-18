package com.nike.models;

public class OrderRequest {
    private int orderId;
    private int memberId;
    private String productName;
    private int costPoints;
    private int previousPoints;

    public OrderRequest(int orderId, int memberId, String productName, int costPoints, int previousPoints) {
        this.orderId = orderId;
        this.memberId = memberId;
        this.productName = productName;
        this.costPoints = costPoints;
        this.previousPoints = previousPoints;
    }

    public OrderRequest() {
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

    public int getPreviousPoints() {
        return previousPoints;
    }

    public void setPreviousPoints(int previousPoints) {
        this.previousPoints = previousPoints;
    }
}
