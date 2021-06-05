package com.iti.OrderAPI.OrderStatusAPI.Services;

import java.util.List;

import com.iti.OrderAPI.OrderStatusAPI.Database.AccessHandler;
import com.iti.OrderAPI.OrderStatusAPI.Model.Order;
import com.iti.OrderAPI.OrderStatusAPI.Model.User;

public class OrderStatusService {
	
	
	public List<Order> getOrderStatus(String userName) {
		return AccessHandler.getOrderStatus(userName);
	}

}
