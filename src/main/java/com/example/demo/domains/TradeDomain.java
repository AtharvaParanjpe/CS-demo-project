package com.example.demo.domains;

import java.sql.Date;



public class TradeDomain {
	private int orderId;	
	private String ticker;
	private int traderId;
	private int quantity;
	private int price;
	private int validity;
	private int orderStatus;  //for open,fulfilled,
	private int orderType; // for market/limit
	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}
	private int buySell; // for buy/sell
	private Date times ; // for timestamp
	
	public TradeDomain() {
		
	}
	
	
	
	public TradeDomain(int orderId, String ticker, int traderId, int quantity, int price, int validity, int orderStatus,
			int orderType, int buySell, Date times) {
		super();
		this.orderId = orderId;
		this.ticker = ticker;
		this.traderId = traderId;
		this.quantity = quantity;
		this.price = price;
		this.validity = validity;
		this.orderStatus = orderStatus;
		this.orderType = orderType;
		this.buySell = buySell;
		this.times = times;
	}

	@Override
	public String toString() {
		return "TradeDomain [orderId=" + orderId + ", ticker=" + ticker + ", traderId=" + traderId + ", quantity="
				+ quantity + ", price=" + price + ", validity=" + validity + ", orderStatus=" + orderStatus
				+ ", orderType=" + orderType + ", buySell=" + buySell + ", times=" + times + "]";
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getTraderId() {
		return traderId;
	}
	public void setTraderId(int traderId) {
		this.traderId = traderId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getBuySell() {
		return buySell;
	}
	public void setBuySell(int buySell) {
		this.buySell = buySell;
	}
	public Date getTimes() {
		return times;
	}
	public void setTimes(Date times) {
		this.times = times;
	}

	
	
	

}
