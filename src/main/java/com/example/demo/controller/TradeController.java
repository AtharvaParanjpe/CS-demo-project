package com.example.demo.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domains.TraderDomain;
import com.example.demo.exceptions.NegativeValueException;
import com.example.demo.services.TradeServices;

@RestController
public class TradeController {
	@Autowired
	TradeServices ts; // created in the service layer
	
	//change quantity
	@RequestMapping(value="/update/orderId/{orderId}/quantity/{qty}")
	public String update_q(@PathVariable(value="orderId") int orderId,@PathVariable(value="qty") int qty){
		if(orderId<0||qty<0)
		{
			throw new NegativeValueException("Negative Value");
		}
		else 
			if(ts.getIfTradeOpen(orderId)) {
				ts.update_qty(orderId,qty);
			}
			else
			{
				throw new NegativeValueException("Status is not OPEN");
			}
		return "Value upadted";
	}
	
	//change price
	@RequestMapping(value="/update/orderId/{orderId}/price/{price}")
	public String update_p(@PathVariable(value="orderId") int orderId,@PathVariable(value="price") int price){
		if(orderId<0||price<0)
		{
			throw new NegativeValueException("Negative Value");
		}
		else 
			if(ts.getIfTradeOpen(orderId)) {
				ts.update_price(orderId,price);
			}
			else
			{
				throw new NegativeValueException("Status is not OPEN");
			}
		return "Value Updated";
	}
	
	//change order type
	@RequestMapping(value="/update/orderId/{orderId}/traderId/{traderId}/orderType/{orderType}")
	public String update_o(@PathVariable(value="orderId") int orderId,@PathVariable(value="orderType") int orderType,
			@PathVariable(value="traderId") int traderId){
		if(orderId<0||orderType<0)
			{
				throw new NegativeValueException("Negative Value");
			}
		else 
			if(ts.getIfTradeOpen(orderId)) {
				ts.update_orderType(orderId,orderType,traderId);
			
			}
			else
			{
				throw new NegativeValueException("Status is not OPEN");
			}
		return "Value Updated";
	}

	@RequestMapping(value="/top5/{trades}")
	public List<TraderDomain> topFiveTrades(@PathVariable(value="trades") String trades){
			if(trades.equalsIgnoreCase("trade"))
				return ts.getTop5Trades();
			else
			if(trades.equalsIgnoreCase("Volume"))
				return ts.getTop5TradesByVolume();
			else
			return null;		
	}
	
	
	
}
