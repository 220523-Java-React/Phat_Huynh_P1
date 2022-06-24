package com.revature.repository;

import com.revature.model.Car;
import com.revature.model.Role;
import com.revature.model.User;
import com.revature.util.ConnectionUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;


public class UserRepository implements DAO<User> {
    private static final Logger logger = LoggerFactory.getLogger(UserRepository.class);
  @Override
  public User create(User user) {
      String sql = "insert into users(first_name, last_name, username, password, role_id) values(?,?,?,?,?)";

      try (Connection connection = ConnectionUtility.getConnection()){
          PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
          stmt.setString(1, user.getFirstname());
          stmt.setString(2, user.getLastname());
          stmt.setString(3, user.getUsername());
          stmt.setString(4, user.getPassword());
          stmt.setInt(5, user.getRole().ordinal());

          int success = stmt.executeUpdate();

          ResultSet keys = stmt.getGeneratedKeys();
          if(keys.next()) {
              int id = keys.getInt(1);
              return user.setId(id);
          }

      } catch (SQLException e){
          e.printStackTrace();
      }

      return null;
  }
    public List<User> getAllByRole(Role role){
        // Empty lists of users, will add any new users from the result set
        List<User> users = new ArrayList<>();
        String sql = "select * from users where role_id = ? order by id";

        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, role.ordinal());

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                // go through each result, build a User object for that data, add that user object the users list
                users.add(new User()
                        .setLastname(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setFirstname(results.getString("first_name"))
                        .setId(results.getInt("id"))
                        .setRole(Role.values()[results.getInt("role_id")])
                );
            }
        }catch(SQLException e){
            logger.warn(e.getMessage());
        }

        return users;
    }


    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from users";
        try(Connection connection = ConnectionUtility.getConnection()){
            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet results = stmt.executeQuery();

            while(results.next()){
                users.add(new User()
                        .setLastname(results.getString("last_name"))
                        .setUsername(results.getString("username"))
                        .setPassword(results.getString("password"))
                        .setFirstname(results.getString("first_name"))
                        .setId(results.getInt("id"))
                        .setRole(Role.values()[results.getInt("role_id")]));





                User user2 = new User().setFirstname("first");

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