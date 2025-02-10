package org.deacasa.controller;

import org.deacasa.entity.UserProduct;
import org.deacasa.service.UserProductService;
import org.deacasa.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users-product")
public class UserProductController {
    private final UserProductService userProductService;

    public UserProductController(UserProductService userProductService) {
        this.userProductService = userProductService;
    }
    @GetMapping("/get-all-users-product")
    public List<UserProduct>getAllUsersProduct(){
        return  userProductService.getAllUsersProduct();
    }

    @GetMapping("/get-users-product-by-id")
    public  UserProduct getUsersProductById(@PathVariable Long id){
        return  userProductService.getUserProductById(id);
    }

    @PostMapping("/save-users-product")
    public UserProduct saveUserProduct(@RequestBody UserProduct userProduct){
        return userProductService.saveUserProduct(userProduct);
    }

    @PutMapping("/update-users-product")
    public  UserProduct updateUsersProduct(@PathVariable long id, @RequestBody UserProduct userProduct){
        return  userProductService.updateUserProduct(id, userProduct);
    }

    @DeleteMapping("/delete-users-product")
    public void  deteleUserProduct(@PathVariable Long id){
        userProductService.deleteUserProduct(id);
    }

}
