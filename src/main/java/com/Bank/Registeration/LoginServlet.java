package com.Bank.Registeration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Base64;

 

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int account = Integer.parseInt(request.getParameter("account") );
		String pin = request.getParameter("pin") ;
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null ;
		
		
		
		// Encrypt Pin
				Base64.Encoder encoder = Base64.getEncoder();
				String originalString_pin = pin;
				
				
				
		        String encodedString_pin = encoder.encodeToString(originalString_pin.getBytes());
		
		 
		
	try {
		
		 
		
		
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_db?useSSL=false","Filobateer_Admin","qwert2846");
			PreparedStatement pst = con.prepareStatement("select * from users where Account = ? and Pin = ?   ");
			
			pst.setInt(1,account);
			pst.setString(2,encodedString_pin);
			 
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				session.setAttribute("account",rs.getInt("account"));
				session.setAttribute("full_name", rs.getString("full_name"));
				
				
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			
			
			
			
			
			else {
				
				request.setAttribute("Status", "failed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
		 
		}
		
	}

}
