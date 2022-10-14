package com.Bank.Registeration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

 
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
 


public class DBUtil {

	private String jdbcURL = "jdbc:mysql://localhost:3306/banking_db?useSSL=false";
	private String jdbcUsername = "Filobateer_Admin";
	private String jdbcPassword = "qwert2846";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	
	public List<Client> getClients() throws Exception {
		
		List<Client> clients = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			// get a connection
			myConn = getConnection();
			
			// create sql statement
			String sql = "select * from users order by CURRENT_BALANCE";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				 
				String FULL_NAME = myRs.getString("FULL_NAME");
				String EMAIL = myRs.getString("EMAIL");
				String Pin = myRs.getString("Pin");
				String Re_Pin  = myRs.getString("Re_Pin ");
				
				int Account = myRs.getInt("Account");
				Double CURRENT_BALANCE = myRs.getDouble("CURRENT_BALANCE");
				
				
				// create new student object
				Client tempClient = new Client(FULL_NAME,EMAIL,Pin,Re_Pin,Account,CURRENT_BALANCE);
				
				// add it to the list of students
				clients.add(tempClient);				
			}
			
			return clients;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}
	
	
public List<Transfers> getTransaction() throws Exception {
		
		List<Transfers> transfers = new ArrayList<>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		try {
			
			
			Date date = Calendar.getInstance().getTime();  
		    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
		    String strDate = dateFormat.format(date);  
			
			
			// get a connection
			myConn = getConnection();
			
			// create sql statement
			String sql = "select * from transfer order by DATE_SENT";
			
			myStmt = myConn.createStatement();
			
			// execute query
			myRs = myStmt.executeQuery(sql);
			
			// process result set
			while (myRs.next()) {
				
				// retrieve data from result set row
				 
				int Account = myRs.getInt("Account");
				int NUM_OPERATION = myRs.getInt("NUM_OPERATION");
				int ACCOUNT_RECIEVER = myRs.getInt("ACCOUNT_RECIEVER");
				Double AMOUNT_SENT = myRs.getDouble("AMOUNT_SENT");
				String DATE_SENT = myRs.getString("DATE_SENT");
				
				
				// create new student object
				Transfers tempTransfer = new   Transfers(Account, NUM_OPERATION, ACCOUNT_RECIEVER, AMOUNT_SENT, DATE_SENT);
				
				// add it to the list of students
				transfers.add(tempTransfer);				
			}
			
			return transfers;		
		}
		finally {
			// close JDBC objects
			close(myConn, myStmt, myRs);
		}		
	}

	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

		try {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();   // doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}



	public void addtransaction(Transfers theTransfers) throws Exception {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			myConn = getConnection();
			
			
			//Client client = new Client();
			
			
			// create sql for insert
			String sql = "insert into transfer "
					   + "(Account, ACCOUNT_RECIEVER, AMOUNT_SENT, DATE_SENT) "
					   + "values (?, ?, ?,?)";
			
			myStmt = myConn.prepareStatement(sql);
			
			
			
			
			
			// set the param values for the student
			myStmt.setInt(1, theTransfers.getAccount());
			myStmt.setInt(2, theTransfers.getAccount_Receiver());
			myStmt.setDouble(3, theTransfers.getAmount_Send());
			myStmt.setString(4, theTransfers.getDate_Send());

			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
	}