package org.deacasa.service;

import org.deacasa.entity.User;
import java.util.List;



public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User saveUser(User user);

    User updateUser(Long id, User user);

    void deleteUser(Long id);

    void registerUser(User user);
}
