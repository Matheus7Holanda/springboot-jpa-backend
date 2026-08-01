package com.aprendendospring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aprendendospring.course.entities.OrderItem;
import com.aprendendospring.course.entities.pk.OrderItemPK;
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {


}
