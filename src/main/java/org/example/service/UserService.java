package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.User;
import org.example.repository.UserRepository;

@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;

    public int addUser(String name, String departmentName){
        return this.userRepository.addUser(name, departmentName);
    }


    public User getUserById(int userId) {
        return userRepository.getUserById(userId);
    }
}
