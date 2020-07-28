package com.order.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.manager.dto.OrderBean;
import com.order.manager.repository.OrderRepository;

@Service
@Transactional
public class OrderTransactionalService {
	
	@Autowired
	private OrderRepository repository;
	
	public String createOrder(OrderBean order) {
		return repository.save(order).getCustomerName();
	}
	
	public Optional<OrderBean> getOrder(Integer orderId) {
		return repository.findById(orderId);
	}
	public List<OrderBean> getOrders(){
		return repository.findAll();
	}
}
