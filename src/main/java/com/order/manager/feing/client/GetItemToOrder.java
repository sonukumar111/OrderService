package com.order.manager.feing.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.order.manager.dto.OrderItem;

@FeignClient(name = "order-item", url = "http://localhost:4001")
public interface GetItemToOrder {
	
	@PostMapping("/order/item/getItem/{user}")
	public List<OrderItem>  getItemByUser(@PathVariable String user);
}
