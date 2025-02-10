package org.deacasa.repository;

import org.deacasa.entity.ProductDescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDescriptionRepo extends JpaRepository<ProductDescription, Long> {


}
