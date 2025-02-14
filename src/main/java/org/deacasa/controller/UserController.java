package org.deacasa.controller;

import org.deacasa.entity.User;
import org.deacasa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);


    private final UserService userService;
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get-all-users")
    public List<User>getAllusers(){
        logger.info("User Controller: get user list");
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id")

    public User getUserById(@PathVariable Long id){
        logger.info("User Controller: get user by id: {}",id);
        return userService.getUserById(id);
    }

    @PostMapping("/save-user")

    public  User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @PutMapping("/update-user")

    public  User updateUser(@PathVariable Long id, @RequestBody User user){
        return  userService.updateUser(id, user);
    }

    @DeleteMapping("/delete-user")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
