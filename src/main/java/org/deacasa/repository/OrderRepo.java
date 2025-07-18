package org.deacasa.repository;

import org.deacasa.entity.Category;
import org.deacasa.entity.Order;
import org.deacasa.entity.Product;
import org.deacasa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
    List<Order> findByUser_UserId(Long userId);

}
