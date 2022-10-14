package com.Bank.Registeration;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

 
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
 
 
 

/**
 * Servlet implementation class Controller_Servlet
 */
@WebServlet("/Controller_Servlet")
public class Controller_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DBUtil dbUtil ;
	
	
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			dbUtil = new DBUtil();
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listTransaction(request, response);
				break;
				
			case "ADD":
				addtransaction(request, response);
				break;
				
			case "LOAD":
				//loadStudent(request, response);
				break;
				
			case "UPDATE":
				//updateStudent(request, response);
				break;
			
			case "DELETE":
				//deleteStudent(request, response);
				break;
				
			default:{
				listTransaction(request, response);
			}
			}
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}
		
		 

	private void listclients(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Client> Clients = dbUtil.getClients();
		
		// add Clients to the request
		request.setAttribute("TheClints", Clients);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
		
	
	

	

	private void listTransaction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get students from db util
		List<Transfers> transfers = dbUtil.getTransaction();
		
		// add Clients to the request
		request.setAttribute("TRANSACTION_LIST", transfers);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void addtransaction(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		// read student info from form data
		
	    
		int  Account_Sender = Integer.parseInt( request.getParameter("account") );
		int  Account_Receiver = Integer.parseInt( request.getParameter("Account_Receiver") );
		Double Amount_Sent = Double.parseDouble(request.getParameter("amount_Send")) ;
		String date = new SimpleDateFormat("dd-MM-yyyy     hh:mm:ss").format(new Date());
	 
				// create a new theTransfers object
		Transfers theTransfers = new Transfers(Account_Sender, Account_Receiver,Amount_Sent ,date);
				
				// add the transaction to the database
				dbUtil.addtransaction(theTransfers);
						
				// send back to main page (the Transaction list)
				listTransaction(request, response);
				response.sendRedirect("index.jsp");
		
	}
	
	 
	
}
