package com.example.fall24_tutor.service;

import com.example.fall24_tutor.entity.SinhVien;

import java.util.ArrayList;

public interface SinhVienService {

    ArrayList<SinhVien> getList();

    Boolean delete(Integer id);
}
