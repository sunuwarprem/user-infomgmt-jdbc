package com.userinfo.jdbc.dao;

import com.userinfo.jdbc.dbutils.DBUtil;
import com.userinfo.jdbc.model.User;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.userinfo.jdbc.dbutils.QueryUtils.*;

public class userDaoImp implements UserDao{
    @Override
    public int saveUser(User user) {
        int saved=0;
        //database try catch here
        try(PreparedStatement ps=DBUtil.getConnection().prepareStatement(SAVE_USER))
        {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddress());
            ps.setLong(5,   user.getPhone());
            ps.setDate(6, new Date(user.getDob().getTime()));
            ps.setBoolean(7, user.isStatus());
            saved=ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return saved;
    }

    @Override
    public int updateUser(User user) {
        int update=0;
        try(PreparedStatement ps=DBUtil.getConnection().prepareStatement(UPDATE_USER)){
            ps.setString(1, user.getUsername());
           update = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return update;
    }

    @Override
    public int deleteUser(int id) {
        int deleted=0;
        try(PreparedStatement ps=DBUtil.getConnection().prepareStatement(DELETE_USER)){
            ps.setInt(1, id);
          deleted= ps.executeUpdate();
            System.out.println("deleted "+deleted);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return deleted;
    }

    @Override
    public List<User> listUser() {
        List<User> users=new ArrayList<>();
        try(PreparedStatement ps=DBUtil.getConnection().prepareStatement(List_USERS)){
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setAddress(rs.getString("email"));
                user.setEmail(rs.getString("address"));
                user.setAddress(rs.getString("phone"));
                user.setDob(rs.getDate("dob"));
                user.setStatus(rs.getBoolean("status"));
                users.add(user);
            }
            } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }
}
