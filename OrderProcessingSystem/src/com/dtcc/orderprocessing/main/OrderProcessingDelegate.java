package com.dtcc.orderprocessing.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessingDelegate {
	
	public static Map<String, Integer> itemList = new HashMap<String, Integer>();
	
	public static Map<Integer, Order> orderMap = new HashMap<Integer, Order>();
	
	public static int orderCount = 0;
	
	static{
		itemList.put("ITEM1", 10);
		itemList.put("ITEM2", 15);
		itemList.put("ITEM3", 13);
		itemList.put("ITEM4", 22);
		itemList.put("ITEM5", 70);
		
	}


	public List<String> itemsList(){
		ArrayList<String> items = new ArrayList<String>();
		for(String item: OrderProcessingDelegate.itemList.keySet()){
			items.add(item);
		}
	return items;
	}
	
	public Order createOrder(String itemName, int quantity){
		Order order = null;
		int orderQuantity = OrderProcessingDelegate.itemList.get(itemName.toUpperCase());
		if(quantity<=orderQuantity){
			order = new Order();
			order.setOrderId(++OrderProcessingDelegate.orderCount);
			order.setItemSelected(itemName.toUpperCase());
			order.setQuantityNeeded(quantity);
			order.setOrderStatus(OrderConstants.ACCEPTED);
			orderMap.put(OrderProcessingDelegate.orderCount, order);
			//to update quantity of item
			OrderProcessingDelegate.itemList.put(itemName.toUpperCase(), orderQuantity-quantity);
		}
		return order;
	}
	public void modifyStatus(Order order, String newStatus){	
		Order orderModify = orderMap.get(order.getOrderId());
		orderModify.setOrderStatus(newStatus);
	}
	
	public String trackOrder(Order order){
		Order orderTrack = orderMap.get(order.getOrderId());
		return orderTrack.getOrderStatus();
	}
}
