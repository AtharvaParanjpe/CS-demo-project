package com.example.demo.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TradeDao;
import com.example.demo.domains.TraderDomain;

@Service
public class TradeServices {
	@Autowired
	private TradeDao tradeDao;
	
	public void update_qty(int orderId, int qty) {
		// TODO Auto-generated method stub
		tradeDao.updateQuantity(orderId,qty);
	}
	
	public void update_price(int orderId, int price) {
		// TODO Auto-generated method stub
		tradeDao.updatePrice(orderId,price);
	}
	
	public void update_orderType(int orderId, int orderType, int traderId) {
		// TODO Auto-generated method stub
		tradeDao.updateOrderType(orderId,orderType,traderId);
	}

	public boolean getIfTradeOpen(int orderId) {
		// TODO Auto-generated method stub
		return tradeDao.getIfTradeOpen(orderId);
	}

	public List<TraderDomain> getTop5Trades() {
		// TODO Auto-generated method stub
		return tradeDao.getTopFiveTrades();
	}
	
	public List<TraderDomain> getTop5TradesByVolume() {
		// TODO Auto-generated method stub
		return tradeDao.getTopFiveTradesByVolume();
	}
	
	

}
