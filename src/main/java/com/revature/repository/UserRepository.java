package com.revature.repository;

import com.revature.model.Car;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class UserRepository implements DAO<User> {

  @Override
  public User create(User user) {
      String sql = "insert into users(first_name, last_name, username, password) values(?,?,?,?)";
      Connection connection = ConnectionUtility.getConnection();
      try{
          PreparedStatement stmt = connection.prepareStatement(sql);
          stmt.setString(1, user.getFirstname());
          stmt.setString(2, user.getLastname());
          stmt.setString(3, user.getUsername());
          stmt.setString(4, user.getPassword());

          int success = stmt.executeUpdate();

      } catch (SQLException e){
          e.printStackTrace();
      }

      return null;
  }



    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        Connection connection = ConnectionUtility.getConnection();
        String sql = "select * from users";
        try{
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                User user = new User();
                user.setFirstname(results.getString("first_name"));
                user.setLastname(results.getString("last_name"));
                user.setUsername(results.getString("username"));
                user.setPassword(results.getString("password"));
                user.setId(results.getInt("id"));

                users.add(user);
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public User getById(int id) {
       return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}