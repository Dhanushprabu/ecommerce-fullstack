package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author d_thirug
 */
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
@CrossOrigin("http://localhost:4200")
public interface ProductRepo extends JpaRepository<Product,Long> {

    // this is the select * from product where category_id=?
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);

    Page<Product> findByNameContaining(@Param("name") String name,Pageable page);


}
