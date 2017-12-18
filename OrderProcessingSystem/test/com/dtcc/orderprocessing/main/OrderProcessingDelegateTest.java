package com.dtcc.orderprocessing.main;

import java.util.List;
import org.junit.Test;
import junit.framework.Assert;

public class OrderProcessingDelegateTest {

	@Test
	public void itemsListTest(){
		OrderProcessingDelegate delegate = new OrderProcessingDelegate();
		List<String> itemList = delegate.itemsList();
		Assert.assertEquals(OrderProcessingDelegate.itemList.size(), itemList.size());
	}
	
	@Test
	public void createOrderTest(){
		OrderProcessingDelegate delegate = new OrderProcessingDelegate();
		Order order = delegate.createOrder("ITEM1", 2);
		Assert.assertEquals(OrderConstants.ACCEPTED, order.getOrderStatus());
	}
	
	@Test
	public void modifyStatusTest(){
		Order order = new Order();
		order.setOrderId(1);
		order.setItemSelected("ITEM1");
		order.setQuantityNeeded(2);
		order.setOrderStatus(OrderConstants.ACCEPTED);
		OrderProcessingDelegate.orderMap.put(1, order);
		OrderProcessingDelegate delegate = new OrderProcessingDelegate();
		delegate.modifyStatus(order, OrderConstants.PROCESSING);
		Assert.assertEquals(OrderConstants.PROCESSING, order.getOrderStatus());	
	}
	
	@Test
	public void trackOrderTest(){
		Order order = new Order();
		order.setOrderId(1);
		order.setItemSelected("ITEM1");
		order.setQuantityNeeded(2);
		order.setOrderStatus(OrderConstants.ACCEPTED);
		OrderProcessingDelegate.orderMap.put(1, order);
		OrderProcessingDelegate delegate = new OrderProcessingDelegate();
		Assert.assertEquals(OrderConstants.ACCEPTED, delegate.trackOrder(order));
	}
}
