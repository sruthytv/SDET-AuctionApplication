package com.auction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auction.service.SellerService;

@WebServlet("/BidderServlet")
public class BidderServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger("MyLoggerName");
	private static final long serialVersionUID = 1L;
    private boolean status=false;
    public BidderServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoggerAuction.setup();
		logger.info("In BidderServlet doPost method");
		 String Name=request.getParameter("username");
		 String Phone=request.getParameter("phone");
		 String Email=request.getParameter("email");
		 int Amount=Integer.parseInt(request.getParameter("amount"));
		 String item= request.getParameter("showItem");
		 String Address=request.getParameter("address");
			logger.info("Bidder details fetched from UI  "+ Name +","+ Phone+","+Email+","+Amount+","+Address);
			Bidder bid= new Bidder();
			bid.setName(Name);
			bid.setPhone(Phone);
			bid.setEmail(Email);
			bid.setAmount(Amount);
			bid.setAddress(Address);
			SellerService saveBid= new SellerService();
			try {
				status=saveBid.saveBid(bid, item);
						if(status==true){
					logger.info("Bid details added into DB");
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				logger.severe("Bid details could not add. Error!");
				e.printStackTrace();
			}
			
		
		
	}

}
