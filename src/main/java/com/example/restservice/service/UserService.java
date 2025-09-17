package com.example.restservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restservice.pojo.DTO.UserDTO;
import com.example.restservice.pojo.User;
import com.example.restservice.repository.UserRepository;

import org.springframework.beans.BeanUtils;
import java.util.List;
import java.util.Optional;



@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User addUser(UserDTO user) {
        
        User userpojo = new User();
        BeanUtils.copyProperties(user, userpojo);

        return userRepository.save(userpojo);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User updateUser(UserDTO user) {
        Optional<User> userOptional = userRepository.findById(user.getId());
        if (userOptional.isPresent()) {
            User userpojo = userOptional.get();
            BeanUtils.copyProperties(user, userpojo);
            return userRepository.save(userpojo);
        }
        return null;

    }

    @Override
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
