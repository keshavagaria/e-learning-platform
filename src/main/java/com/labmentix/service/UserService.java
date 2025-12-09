package com.labmentix.service;

import com.labmentix.entities.User;
import com.labmentix.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Cacheable(cacheNames = "users",key = "#id")
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        //user.setRoles("ADMIN");
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @CachePut(cacheNames = "users",key="#id")
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(updatedUser.getUsername());
            existingUser.setEmail(updatedUser.getEmail());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public boolean isValidUser(User user) {
        Optional<User> dbUser = getUserByEmail(user.getEmail());
 //       log.info("DB USER : " +  dbUser);
        if(dbUser!=null && user.getPassword().equals(dbUser.get().getPassword())){
            user.setId(dbUser.get().getId());
            user.setUsername(dbUser.get().getUsername());
          //  user.setRoles(dbUser.get().getRoles());
            return true;
        }
        return false;
    }
    public boolean isUserAlreadyExists(String email) {
       Optional<User> dbUser = getUserByEmail(email);
        if(!dbUser.isEmpty()){
            return true;
        }
        return false;
    }

    private Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }


    public User authenticateUser(String username, String password) {

        User savedUser = userRepository.findByUsernameAndPassword(username, password);
        System.out.println("Service Layer  "+savedUser);
        return savedUser;
    }

    @CacheEvict(cacheNames = "users",key="#id")
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
