package com.aprendendospring.course.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendendospring.course.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
