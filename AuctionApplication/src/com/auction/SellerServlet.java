package com.auction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auction.service.SellerService;

/**
 * Servlet implementation class SellerServlet
 */
@WebServlet("/Seller")
public class SellerServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger("MyLoggerName");
	private static final long serialVersionUID = 1L;
	String page="Seller.jsp";  
    boolean status=false;
    public SellerServlet() {
        super();
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoggerAuction.setup();
		logger.info("In doPost method SellerServlet");
		 String item=request.getParameter("item");
		 logger.info("Item "+item);
			SellerService setItem= new SellerService();
			try {
				if(item!=null){
				status=setItem.saveItemName(item);
				if(status==true){
					logger.info("Item added into DB");
					
				}}
			} catch (ClassNotFoundException | SQLException e) {
				logger.severe("Item could not added into DB. Error!");
				e.printStackTrace();
			}
			
		   
		
	}

	

}
