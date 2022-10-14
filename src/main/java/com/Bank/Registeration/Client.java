package com.Bank.Registeration;

public class Client {
	
	 
	private String Full_Name;
	private String Email;
	private String pin;
	private String Re_pin;
	public int Account_Bank;
	private  double current_balance;
	
	
	public Client(String full_Name, String email, String pin, String re_pin, int account_Bank, double current_balance) {
		 
		Full_Name = full_Name;
		Email = email;
		this.pin = pin;
		Re_pin = re_pin;
		Account_Bank = account_Bank;
		this.current_balance = current_balance;
	}
	
	



	public Client() {
	 
	}











	public Client(String full_Name, String email, String pin, String re_pin, int account_Bank) {
 		Full_Name = full_Name;
		Email = email;
		this.pin = pin;
		Re_pin = re_pin;
		Account_Bank = account_Bank;
	}









	public Client(int account_Bank, double current_balance) {
	 
		Account_Bank = account_Bank;
		this.current_balance = current_balance;
	}









	public Client(String full_Name, String email, String pin, int account_Bank, double current_balance) {
	 
		Full_Name = full_Name;
		Email = email;
		this.pin = pin;
		Account_Bank = account_Bank;
		this.current_balance = current_balance;
	}




	public Client(double current_balance2) {
		this.current_balance = current_balance;
	}









	public String getFull_Name() {
		return Full_Name;
	}


	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getRe_pin() {
		return Re_pin;
	}


	public void setRe_pin(String re_pin) {
		Re_pin = re_pin;
	}


	public int getAccount_Bank() {
		return Account_Bank;
	}


	public void setAccount_Bank(int account_Bank) {
		Account_Bank = account_Bank;
	}


	public double getCurrent_balance() {
		return current_balance;
	}


	public void setCurrent_balance(double current_balance) {
		this.current_balance = current_balance;
	}


	@Override
	public String toString() {
		return "Client [Full_Name=" + Full_Name + ", Email=" + Email + ", pin=" + pin + ", Re_pin=" + Re_pin
				+ ", Account_Bank=" + Account_Bank + ", current_balance=" + current_balance + "]";
	}
	
	 	 
	
	
}
