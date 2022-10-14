package com.Bank.Registeration;

import java.io.IOException;
import java.util.Base64;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String full_name = request.getParameter("full_name");
		String email = request.getParameter("email");
		int account = Integer.parseInt(request.getParameter("account") );
		String pin = request.getParameter("pin");
		String re_pin = request.getParameter("re_pin");
		
		
		// Encrypt Pin
		Base64.Encoder encoder = Base64.getEncoder();
		String originalString_pin = pin;
		String originalString_re_pin = re_pin;
		
		
        String encodedString_pin = encoder.encodeToString(originalString_pin.getBytes());
        String encodedString_re_pin = encoder.encodeToString(originalString_re_pin.getBytes());
        
        // decrypt pin
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(originalString_pin);

		
		
		
		
		PrintWriter out = response.getWriter();
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/banking_db?useSSL=false","Filobateer_Admin","qwert2846");
			PreparedStatement pst = con.prepareStatement("insert into users (FULL_NAME , EMAIL , Account , Pin , Re_Pin ) VALUES (?,?,?,?,?)");
			RequestDispatcher dispatcher = null ;
			
			
			pst.setString(1,full_name);
			pst.setString(2,email);
			pst.setInt(3 ,account  );
			pst.setString(4, encodedString_pin );
			pst.setString(5, encodedString_re_pin  );
			
			
			int rowcount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registration.jsp");
			
			out.print(rowcount);
			
			if (rowcount == 1) {
				request.setAttribute("Status", "Success");
 			}
			
			
			else if(pin != re_pin) {
				
				request.setAttribute("Status", "Not_Equal");
			}

			else if(full_name.length() < 9) {
					
					request.setAttribute("Status", "invalide_String");	
				
			}else {
				
				request.setAttribute("Status", "failed");
			}
				
				
			
			dispatcher.forward(request, response);
				
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
