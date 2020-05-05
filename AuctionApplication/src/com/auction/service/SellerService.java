package com.auction.service;

import java.sql.SQLException;
import java.util.List;

import com.auction.Bidder;
import com.auction.dao.SellerDao;

public class SellerService {

	private static final List<Bidder> Bidder = null;
	SellerDao dao = new SellerDao();
	
	public List getBidderData() {
		return dao.getBidderData();
	}
	public boolean saveItemName(String item) throws ClassNotFoundException, SQLException {
		 return dao.addItem(item);
	}
	public Bidder highestBidAmount(){

		int temp=0;
		Bidder selectedBid=null;
		List<Bidder> Bidder= dao.getBidderObject();
		for(Bidder bid: Bidder){
			if(temp<bid.getAmount()){
				temp=bid.getAmount();
				selectedBid=bid;
			}
		}
		return selectedBid;
	}
	public String getItem(){
		return dao.getItem();
	}
	public boolean saveBid(Bidder bid, String item) throws ClassNotFoundException, SQLException{
		return dao.saveBid(bid, item);
	}
}
	