package com.auction.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.auction.Bidder;

public class SellerDao {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		String connectionURL = "jdbc:mysql://localhost:3306/auction_db";
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		
		con = DriverManager.getConnection(connectionURL, "root","mysql");
		if(con != null) {
			//System.out.println("connection established...");
		}
		return con;
	}
	
	public boolean saveBid(Bidder bid, String item) throws ClassNotFoundException, SQLException {
		Connection con = getConnection();
		String sqlQuery = "insert into bidder(Name, Phone, Email, Amount, Address, Item) values(?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		
		ps.setString(1, bid.getName());
		ps.setString(2, bid.getPhone());
		ps.setString(3, bid.getEmail());
		ps.setInt(4, bid.getAmount());
		ps.setString(5, bid.getAddress());
		ps.setString(6,item);
		
		int rows = ps.executeUpdate();
		
		if(con!=null) {
			con.close();
		}
		
		return rows>0?true:false;
	}
	public boolean addItem(String item) throws ClassNotFoundException, SQLException{
		ResultSet rs;
		Connection con = getConnection();
		String sqlQuery = "insert into item(Item) values(?)";
		PreparedStatement ps = con.prepareStatement(sqlQuery);
		ps.setString(1, item);
//		System.out.println("inserted item to db"+item);
		int rows = ps.executeUpdate();
		if(con!=null) {
			con.close();
		}
		
		return rows>0?true:false;
	}
	public String getItem() {

		ResultSet rs;
		String item=null;
		try {
			Connection connection = getConnection();
			String sql = "select * from item";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
			 item=rs.getString("Item");			
			}
			rs.close();
			s.close();
			if(connection!=null) {
				connection.close();
			}

		} catch (Exception e) {

			System.out.println("Exception is ;" + e);

		}

		return item;

	}
	public List getBidderData() {

		ResultSet rs;
		List resultList = new ArrayList();
		try {
			Connection connection = getConnection();
			String sql = "select * from bidder";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				List dataList= new ArrayList();
				dataList.add(rs.getString("Name"));
				dataList.add(rs.getString("Phone"));
				dataList.add(rs.getString("Email"));
				dataList.add(rs.getInt("Amount"));
				dataList.add(rs.getString("Address"));
				resultList.add(dataList);
				

			}
			rs.close();
			s.close();
			if(connection!=null) {
				connection.close();
			}

		} catch (Exception e) {

			System.out.println("Exception is ;" + e);

		}

		return resultList;

	}
	public List<Bidder> getBidderObject() {

		ResultSet rs;
		List<Bidder> resultList = new ArrayList<Bidder>();
		try {
			Connection connection = getConnection();
			String sql = "select * from bidder";
			Statement s = connection.createStatement();
			s.executeQuery(sql);
			rs = s.getResultSet();
			while (rs.next()) {
				Bidder bid= new Bidder();
				bid.setName(rs.getString("Name"));
				bid.setPhone(rs.getString("Phone"));
				bid.setEmail(rs.getString("Email"));
				bid.setAmount(rs.getInt("Amount"));
				bid.setAddress(rs.getString("Address"));
				bid.setItem(rs.getString("Item"));
				resultList.add(bid);

			}
			rs.close();
			s.close();
			if(connection!=null) {
				connection.close();
			}

		} catch (Exception e) {

			System.out.println("Exception is ;" + e);

		}

		return resultList;

	}


}
