package com.Bank.Registeration;

import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
public class Transfers   {
	
  
 	private int account;
	private int Num_Operation ;
	private int Account_Receiver;
	private double amount_Send;
	private String date_Send ;
	
 
	


	public Transfers(int account, int num_Operation, int account_Receiver, double amount_Send, String date_Send) {
	
		this.account = account;
		Num_Operation = num_Operation;
		Account_Receiver = account_Receiver;
		this.amount_Send = amount_Send;
		this.date_Send = date_Send;
	}
	
	
	
	


	public Transfers(int account, int account_Receiver, double amount_Send, String date_Send) {
 		this.account = account;
		Account_Receiver = account_Receiver;
		this.amount_Send = amount_Send;
		this.date_Send = date_Send;
	}












	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public int getNum_Operation() {
		return Num_Operation;
	}

	public void setNum_Operation(int num_Operation) {
		Num_Operation = num_Operation;
	}

	public int getAccount_Receiver() {
		return Account_Receiver;
	}

	public void setAccount_Receiver(int account_Receiver) {
		Account_Receiver = account_Receiver;
	}

	public double getAmount_Send() {
		return amount_Send;
	}

	public void setAmount_Send(double amount_Send) {
		this.amount_Send = amount_Send;
	}

	public String getDate_Send() {
		return date_Send;
	}

	public void setDate_Send(String date_Send) {
		this.date_Send = date_Send;
	}

	@Override
	public String toString() {
		return "Transfers [account=" + account + ", Num_Operation=" + Num_Operation + ", Account_Receiver="
				+ Account_Receiver + ", amount_Send=" + amount_Send + ", date_Send=" + date_Send + "]";
	}
	
	 
	public Double TransactionOP(double d,double amount ) {
		
		return(d - amount);
	}
	
	 

	 
	

}
