//START HERE FOR ATHARVA
package com.example.demo.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.domains.TradeDomain;
import com.example.demo.domains.TraderDomain;
import com.example.demo.exceptions.NegativeValueException;


@Repository
public class TradeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public void updateQuantity(int orderId, int qty) {
		final String sql="UPDATE trade SET quantity = ? WHERE orderId = ?";
		jdbcTemplate.update(sql,new Object[]{qty,orderId});
		
		
	}
	
	public void updatePrice(int orderId, int price) {
		final String sql="UPDATE trade SET price = ? WHERE orderId = ?";
		jdbcTemplate.update(sql,new Object[]{price,orderId});
	}
	
	public void updateOrderType(int orderId, int orderType,int traderId){
		
		List<TradeDomain> orderTypeList = jdbcTemplate.query("SELECT * from trade WHERE orderId=" + orderId, new TraderIdMatchingMapper());
		int t_id = orderTypeList.get(0).getTraderId();
		int o_status = orderTypeList.get(0).getOrderStatus();
		if(t_id==traderId) {	
			final String sql="UPDATE trade SET orderType = ? WHERE orderId = ? AND traderId = ?";
			jdbcTemplate.update(sql,new Object[]{orderType,orderId,traderId});
			}
		else 
		{
			throw new NegativeValueException("Trader Id Did Not Match");
		}
		
		
	}

	public boolean getIfTradeOpen(int orderId) {//update message add logic here
		// TODO Auto-generated method stub
		List<TradeDomain> orderTypeList = jdbcTemplate.query("SELECT orderStatus from trade WHERE orderId=" + orderId, new TradeRowMapper());
		int orderStatus = orderTypeList.get(0).getOrderStatus();
		System.out.println(orderStatus);
		if(orderStatus==0)
		{
			return true;
		}
		return false;
		
	}
	
	//THIS IS FOR UPDATE
	class TradeRowMapper implements RowMapper<TradeDomain>
	{
		@Override
		public TradeDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
			TradeDomain trade = new TradeDomain();
			trade.setOrderStatus(rs.getInt("orderStatus"));
			return trade;
		}
	}
	
	public List<TraderDomain> getTopFiveTrades() {
		// TODO Auto-generated method stub
		
		List<TradeDomain> traderIdList = jdbcTemplate.query("SELECT TRADERID FROM TRADE GROUP BY TRADE.TRADERID ORDER BY COUNT(TRADERID) DESC LIMIT 5;",new TradeDomainMapper());
		int[] traderId=new int[5];
		for (int i = 0; i < traderIdList.size(); i++) {
			traderId[i] = traderIdList.get(i).getTraderId();	
			System.out.println(traderId[i]);
		}
		return jdbcTemplate.query("SELECT * FROM TRADERS WHERE TRADERID IN ("+Integer.toString(traderId[0])+","
				+Integer.toString(traderId[1])+","+Integer.toString(traderId[2])+","+Integer.toString(traderId[3])+","+Integer.toString(traderId[4])+")",new TopFiveTraderRowMapper());
		
	}
	
	public List<TraderDomain> getTopFiveTradesByVolume() {
		// TODO Auto-generated method stub
		
		List<TradeDomain> traderIdList = jdbcTemplate.query("SELECT TRADERID FROM TRADE GROUP BY TRADE.TRADERID ORDER BY SUM(PRICE) DESC LIMIT 5;",new TradeDomainMapper());
		int[] traderId=new int[5];
		for (int i = 0; i < traderIdList.size(); i++) {
			traderId[i] = traderIdList.get(i).getTraderId();
			System.out.println();
			System.out.println(traderId[i]);
		}
		return jdbcTemplate.query("SELECT * FROM TRADERS WHERE TRADERID IN ("+Integer.toString(traderId[0])+","
				+Integer.toString(traderId[1])+","+Integer.toString(traderId[2])+","+Integer.toString(traderId[3])+","+Integer.toString(traderId[4])+")",new TopFiveTraderRowMapper());
		
	}
	//ROW MAPPER FOR TRADER TABLE 
	class TopFiveTraderRowMapper implements RowMapper<TraderDomain>
	{
		@Override
		public TraderDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
			TraderDomain user=new TraderDomain();
			user.setTraderId(rs.getInt("traderId"));
			user.setFirstName(rs.getString("firstName"));
			user.setLastName(rs.getString("lastName"));
			user.setEmail(rs.getString("email"));
			user.setAddress(rs.getString("address"));
			user.setContact(rs.getDouble("contact"));
			return user;
		}
	}
}


//ROW MAPPER FOR TRADE TABLE
class TradeDomainMapper implements RowMapper<TradeDomain>
{
	@Override
	public TradeDomain mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		TradeDomain user=new TradeDomain();
		
//		user.setOrderId(rs.getInt("orderId"));
//		user.setTicker(rs.getString("ticker"));
		user.setTraderId(rs.getInt("traderId"));
//		user.setQuantity(rs.getInt("quantity"));
//		user.setPrice(rs.getInt("price"));
//		user.setValidity(rs.getInt("validity"));
//		user.setOrderType(rs.getInt("orderType"));
//		user.setOrderStatus(rs.getInt("orderStatus"));
//		user.setBuySell(rs.getInt("buySell"));
//		user.setTimes(rs.getDate("times"));
		
		return user;
	}
}

class TraderIdMatchingMapper implements RowMapper<TradeDomain>
{
	@Override
	public TradeDomain mapRow(ResultSet rs,int rowNum) throws SQLException
	{
		TradeDomain user=new TradeDomain();
		
		user.setOrderId(rs.getInt("orderId"));
		user.setTicker(rs.getString("ticker"));
		user.setTraderId(rs.getInt("traderId"));
		user.setQuantity(rs.getInt("quantity"));
		user.setPrice(rs.getInt("price"));
		user.setValidity(rs.getInt("validity"));
		user.setOrderType(rs.getInt("orderType"));
		user.setOrderStatus(rs.getInt("orderStatus"));
		user.setBuySell(rs.getInt("buySell"));
		user.setTimes(rs.getDate("times"));
	
		return user;
	}
}
//END HERE FOR ATHARVA