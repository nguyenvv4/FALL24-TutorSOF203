package com.example.fall24_tutor.repository;

import com.example.fall24_tutor.User;
import com.example.fall24_tutor.entity.SinhVien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SinhVienRepo {
    DbConnection dbConnection;

    public ArrayList<SinhVien> getList() {
        String sql = "select * from sinh_vien sv";
        ArrayList<SinhVien> list = new ArrayList<>();
        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                Integer age = rs.getInt("age");
                String status = rs.getString("status");
                Integer lopHoc = rs.getInt("lop_hoc");
                list.add(new SinhVien(id, name, address, age, status, lopHoc));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean delete(Integer id) {
        String sql = "delete from sinh_vien where id  = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setObject(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
