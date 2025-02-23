package org.deacasa.service;

import org.deacasa.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;



public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);


    User updateUser(Long id, User user);

    void deleteUser(Long id);

    void registerUser(User user);

    String verifyUser(User user);
}
