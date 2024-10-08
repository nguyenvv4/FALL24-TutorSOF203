package com.example.fall24_tutor;

public class User {
    private String id;
    private String name;
    private Integer age;
    private String address;
    private String status;

    public User() {
    }

    public User(String id, String name, Integer age, String address, String status) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
