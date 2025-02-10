package org.deacasa.controller;


import org.deacasa.entity.User;
import org.deacasa.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get-all-users")

    public List<User>getAllusers(){
        return userService.getAllUsers();
    }

    @GetMapping("/get-user-by-id")

    public User getUserById(@PathVariable Long id){
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
