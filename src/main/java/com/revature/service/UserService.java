package com.revature.service;

import com.revature.model.User;
import com.revature.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public UserService(List<User> users) {
        this.userRepository = new UserRepository();
    }

    public User createUser(User user) {
        return userRepository.create(user);
    }

    public List<User> getAllUsers() {
        return userRepository.getAll();
    }

    public User getUserById(int id) {
        return userRepository.getById(id);
    }

    // public boolean deleteUserById(int id){
    //     for(int i = 0; i < users.size(); i++){
    //       if(users.get(i).getId() == id){
    //          users.remove(i);
    //          return true;
    //      }
    //     }

    // return false;
//}
}
