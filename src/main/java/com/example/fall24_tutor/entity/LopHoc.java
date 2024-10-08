package com.example.fall24_tutor.entity;

public class LopHoc {

    private Integer id;

    private String className;

    public LopHoc(Integer id, String className) {
        this.id = id;
        this.className = className;
    }

    public LopHoc() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
