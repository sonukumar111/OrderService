package com.order.manager.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.manager.dto.OrderBean;
import com.order.manager.dto.OrderItem;
import com.order.manager.exception.InvalidUserFound;
import com.order.manager.exception.OrderNotFound;
import com.order.manager.feing.client.GetItemToOrder;
import com.order.manager.service.OrderTransactionalService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderTransactionalService service;
	
	@Autowired
	private GetItemToOrder getItems;
	
	@PostMapping("/create")
	public ResponseEntity<String> createOrder(@Valid @RequestBody OrderBean order){
		List<OrderItem> list=new ArrayList<>();
		if(order.getCustomerName()!="")
			 list=getItems.getItemByUser(order.getCustomerName());
		if(list.size()==0)
			throw new InvalidUserFound("Invalid user privillege, please try again");
		order.setOrderItems(list);
		System.out.println("Complete Order ::: "+order);
		System.out.println("Produt list : "+list);
		
		String user=service.createOrder(order);
		return new ResponseEntity<String>("Hello "+user+" Your order has been placed.",HttpStatus.CREATED);
	}
	@GetMapping("/get/{orderId}")
	public ResponseEntity<OrderBean> getOrder(@PathVariable Integer orderId){
		OrderBean order=service.getOrder(orderId)
		       .orElseThrow(()->new OrderNotFound("Order Not found with Id : "+orderId));
		return new ResponseEntity<OrderBean>(order,HttpStatus.OK);
	}
	@GetMapping("/getOrders")
	public ResponseEntity<List<OrderBean>> getOrders(){
		List<OrderBean> orders= service.getOrders();
		if(orders.size()==0)
			throw new OrderNotFound("NO Data found");
		return new ResponseEntity<List<OrderBean>>(orders,HttpStatus.OK);
	}
}
