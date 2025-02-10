package org.deacasa.repository;

import org.deacasa.entity.UserProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProductRepo extends JpaRepository<UserProduct, Long> {


}
