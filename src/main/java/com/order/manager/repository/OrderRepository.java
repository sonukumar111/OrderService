package com.order.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.manager.dto.OrderBean;

@Repository
public interface OrderRepository extends JpaRepository<OrderBean, Integer> {

}
