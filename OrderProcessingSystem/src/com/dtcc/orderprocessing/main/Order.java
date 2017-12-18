package com.dtcc.orderprocessing.main;

public class Order {

	private Integer orderId;
	
	private String itemSelected;
	
	private Integer quantityNeeded;
	
	private String orderStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getItemSelected() {
		return itemSelected;
	}

	public void setItemSelected(String itemSelected) {
		this.itemSelected = itemSelected;
	}

	public Integer getQuantityNeeded() {
		return quantityNeeded;
	}

	public void setQuantityNeeded(Integer quantityNeeded) {
		this.quantityNeeded = quantityNeeded;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
}
