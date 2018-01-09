package BMS;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable{
	private String name;
	private String dob;
	private String id;
	private double amount;
	private String password;
	private boolean filled;
	private long timeCreated;
	private long previousTime;// Used it to do a Savings Accounts Calculation
	private String AccountType;
	
	public Account(){
		
	}
	public Account(String name, String dob,String password, String id, String AccountType){
		setName(name);
		setDob(dob);
		setPassword(password);
		setId(id);
		setAccountType(AccountType);
		setAmount(0.00);
		setFilled(true);
		setTimeCreated();
		previousTime = timeCreated;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isFilled() {
		return filled;
	}
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String accountType) {
		AccountType = accountType;
	}
	public long getTimeCreated() {
		return timeCreated;
	}
	public void setTimeCreated() {
		timeCreated = System.currentTimeMillis();
	}
	public long getPreviousTime() {
		return previousTime;
	}
	public void setPreviousTime(long previousTime) {
		this.previousTime = previousTime;
	}
	public void deposit(double deposit){
		amount = amount + deposit;
	}
	public boolean withdraw(double withdraw){
		if(amount - withdraw < 0){
			return false;
		}
		else{
		amount = amount - withdraw;
		return true;
		}
	}
}
