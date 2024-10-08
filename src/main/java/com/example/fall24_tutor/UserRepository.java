package com.example.fall24_tutor;

import com.example.fall24_tutor.repository.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserRepository {
    DbConnection dbConnection;

    public ArrayList<User> getList() {
        String sql = "SELECT * from users ";
        ArrayList<User> list = new ArrayList<>();
        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String address = rs.getString("address");
                String status = rs.getString("status");
                list.add(new User(id, name, age, address, status));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean addNew(User user) {
        String sql = "insert into users (id, name, age, address, status)\n" +
                " values (?,?,?,?,?)";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setObject(1, user.getId());
            ps.setObject(2, user.getName());
            ps.setObject(3, user.getAge());
            ps.setObject(4, user.getAddress());
            ps.setObject(5, user.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(String id) {
        String sql = "delete from users where id  = ?";
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

    public User detail(String id ){
        String sql = "SELECT * from users WHERE id = ?";
        User user = new User();
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String idUser = rs.getString("id");
                String name = rs.getString("name");
                Integer age = rs.getInt("age");
                String address = rs.getString("address");
                String status = rs.getString("status");
                user = new User(idUser, name, age, address, status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public Boolean update(User user) {
        String sql = "update users set name = ?,\n" +
                "age = ? ,\n" +
                "address = ?,\n" +
                "status = ?\n" +
                "where id = ?";
        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            ps.setObject(5, user.getId());
            ps.setObject(1, user.getName());
            ps.setObject(2, user.getAge());
            ps.setObject(3, user.getAddress());
            ps.setObject(4, user.getStatus());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
