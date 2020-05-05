package com.auction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.auction.service.SellerService;

@WebServlet("/Welcome")
public class WelcomeServlet extends HttpServlet {
	private static final Logger logger=Logger.getLogger("MyLoggerName");
	private static final long serialVersionUID = 1L;

	SellerService sellerService = new SellerService();
	public WelcomeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		LoggerAuction.setup();
		logger.info("In doPost method WelcomeServlet");

		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("Welcome.jsp").include(request, response);

		String user = request.getParameter("user");
		logger.info("User selected as "+user);
		RequestDispatcher dispatcher = null;

		if (user.equals("Bidder")) {
			logger.info("Item Name " + sellerService.getItem());
			request.setAttribute("item", sellerService.getItem());
			dispatcher = getServletContext()
					.getRequestDispatcher("/Bidder.jsp");
		} else  {
			List bidList= sellerService.getBidderData();
			logger.info("List of Bids" +bidList+" Total Size is "+bidList.size() );
			request.setAttribute("data", sellerService.getBidderData());
			request.setAttribute("item", sellerService.getItem());
			dispatcher = getServletContext()
					.getRequestDispatcher("/Seller.jsp");
		}

		dispatcher.forward(request, response);
		out.close();

	}

}
