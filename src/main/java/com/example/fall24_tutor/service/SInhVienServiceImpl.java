package com.example.fall24_tutor.service;

import com.example.fall24_tutor.entity.SinhVien;
import com.example.fall24_tutor.repository.SinhVienRepo;

import java.util.ArrayList;

public class SInhVienServiceImpl implements SinhVienService{

    SinhVienRepo sinhVienRepo = new SinhVienRepo();
    @Override
    public ArrayList<SinhVien> getList() {
        ArrayList<SinhVien> list = sinhVienRepo.getList();
        return list;
    }

    @Override
    public Boolean delete(Integer id) {
        return sinhVienRepo.delete(id);
    }
}
