package org.deacasa.service.Impl;

import org.deacasa.entity.UserProduct;
import org.deacasa.repository.UserProductRepo;
import org.deacasa.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProductServiceImpl implements UserProductService {
    private final UserProductRepo userProductRepo;
    @Autowired
    public UserProductServiceImpl(UserProductRepo userProductRepo){this.userProductRepo=userProductRepo;}


    @Override
    public List<UserProduct> getAllUsersProduct() {
        return userProductRepo.findAll();
    }

    @Override
    public UserProduct getUserProductById(Long id) {
        return userProductRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("UserProduct not found"));
    }

    @Override
    public UserProduct saveUserProduct(UserProduct userProduct) {
        return userProductRepo.save(userProduct);
    }

    @Override
    public UserProduct updateUserProduct(Long id, UserProduct userProduct) {
        UserProduct userProduct1 =getUserProductById(id);
        userProduct1.setCustomerId(userProduct.getCustomerId());
        userProduct1.setProductId(userProduct.getProductId());
        return userProductRepo.save(userProduct1);
    }

    @Override
    public void deleteUserProduct(Long id) {
        userProductRepo.deleteById(id);
    }
}
