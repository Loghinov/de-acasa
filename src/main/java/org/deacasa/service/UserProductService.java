package org.deacasa.service;


import org.deacasa.entity.UserProduct;
import java.util.List;


public interface UserProductService {
    List<UserProduct> getAllUsersProduct();

    UserProduct getUserProductById(Long id);

    UserProduct saveUserProduct(UserProduct userProduct);

    UserProduct updateUserProduct(Long id, UserProduct userProduct);

    void deleteUserProduct(Long id);

}
