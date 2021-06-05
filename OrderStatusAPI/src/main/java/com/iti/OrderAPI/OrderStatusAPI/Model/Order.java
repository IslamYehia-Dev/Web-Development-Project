package com.iti.OrderAPI.OrderStatusAPI.Model;

public class Order {
	private int orderNumber;
	private String orderDate;
	private int orderStatus;
	public Order() {
		
	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
this.orderStatus=orderStatus;
	}

	
	
}
