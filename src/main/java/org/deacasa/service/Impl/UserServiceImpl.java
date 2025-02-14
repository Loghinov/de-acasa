package org.deacasa.service.Impl;

import org.deacasa.entity.User;
import org.deacasa.repository.UserRepo;
import org.deacasa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepo userRepo;
    @Autowired
    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() ->new RuntimeException("User not found"));
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        User user1 = getUserById(id);
        user1.setUserFirstName(user.getUserFirstName());
        user1.setUserLastName(user.getUserLastName());
        user1.setUserEmail(user.getUserEmail());
        user1.setUserPhoneNumber(user.getUserPhoneNumber());
        user1.setUserStatus(user.getUserStatus());
        user1.setCreatedDateTime(user.getCreatedDateTime());
        user1.setRoleId(user.getRoleId());
        user1.setOrderId(user.getOrderId());
        user1 = userRepo.save(user1);
        logger.info("User was updated successfully: {}",user1);
        return user1;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }

    @Override
    public void registerUser(User user) {

    }
    //  TODO implement authorization
}
