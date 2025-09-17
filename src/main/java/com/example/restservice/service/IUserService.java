package com.example.restservice.service;

import com.example.restservice.pojo.DTO.UserDTO;
import com.example.restservice.pojo.User;
import java.util.List;

public interface IUserService {

    User addUser(UserDTO user);
    List<User> getAllUsers();
    User getUserById(int id);

    User updateUser(UserDTO user);
    boolean deleteUser(int id);
}
