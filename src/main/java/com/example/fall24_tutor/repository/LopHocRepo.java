package com.example.fall24_tutor.repository;

import com.example.fall24_tutor.entity.LopHoc;
import com.example.fall24_tutor.entity.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LopHocRepo {

    DbConnection dbConnection;

    public ArrayList<LopHoc> getList() {
        String sql = "select * from lop_hoc";
        ArrayList<LopHoc> list = new ArrayList<>();
        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String className = rs.getString("class_name");
                list.add(new LopHoc(id, className));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
