package com.aprendendospring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.aprendendospring.course.entities.Order;


public interface OrderRepository extends JpaRepository<Order, Long> {


}
