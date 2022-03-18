package com.doge.models;

public class Member {

    private Integer id;
    private String name;
    private Integer points;
    private String address;
    private String phoneNumber;

    public Member() {
    }

    public Member(Integer id, String name, Integer points, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.points = points;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
