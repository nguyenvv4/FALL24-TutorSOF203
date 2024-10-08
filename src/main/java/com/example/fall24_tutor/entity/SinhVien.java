package com.example.fall24_tutor.entity;

public class SinhVien {

    private Integer id;

    private String name;

    private String address;

    private Integer age;

    private String status;

    private Integer lopHoc;

    public SinhVien() {
    }

    public SinhVien(Integer id, String name, String address, Integer age, String status, Integer lopHoc) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.status = status;
        this.lopHoc = lopHoc;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(Integer lopHoc) {
        this.lopHoc = lopHoc;
    }
}
