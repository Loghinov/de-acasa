package org.deacasa.service.Impl;

import org.deacasa.configuration.security.JwtUtils;
import org.deacasa.entity.Role;
import org.deacasa.entity.User;
import org.deacasa.repository.RoleRepo;
import org.deacasa.repository.UserRepo;
import org.deacasa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;


    @Autowired
    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, RoleRepo roleRepo, AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.roleRepo = roleRepo;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
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
        user1.setRole(user.getRole());
        user1.setOrderId(user.getOrderId());
        user1 = userRepo.save(user1);
        logger.info("User was updated successfully: {}", user1);
        return user1;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }

    @Override
    public String verifyUser(User user) {
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getUserPassword()));
        if(authentication.isAuthenticated())
            return jwtUtils.generateToken(user.getUserName());
        return "failed";
    }



    @Override
    public void registerUser(User user) {
        // Шифруем пароль перед сохранением
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

            Role role = roleRepo.findById(user.getRole().getRoleId())
                    .orElseThrow(() -> new RuntimeException("Role not found"));
            user.setRole(role);

        // Сохраняем пользователя
        userRepo.save(user);
    }
}