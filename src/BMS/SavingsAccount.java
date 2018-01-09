package BMS;

import java.util.*;

public class SavingsAccount {
	Account acc = null;
	private int interestRate = 10;
	
	
	public SavingsAccount(Account acc){
		this.acc = acc;
	}
	public void amountChange(){
		
		double interest = acc.getAmount() * interestRate * monthCalculation() / 1200;
		acc.setAmount(interest + acc.getAmount());
		
	}
	public int monthCalculation(){
		int month = 0;
		long preTime = acc.getPreviousTime();
		Date preDate = new Date(preTime);
		long curTime = System.currentTimeMillis();
		Date currentDate = new Date(curTime);
		
		if(currentDate.getYear()-preDate.getYear() == 0){
			if(currentDate.getMonth()-preDate.getMonth() == 0){
				return 0;
			}
			else{
				if(currentDate.getDate() - preDate.getDate() < 0){
					month = currentDate.getMonth()-preDate.getMonth() - 1;
				}
				else
					month = currentDate.getMonth()-preDate.getMonth();
			}
			
			
		}
		else{
			month = (currentDate.getYear() - preDate.getYear())*12 + (currentDate.getMonth()-preDate.getMonth());
			if(currentDate.getDate() - preDate.getDate() < 0){
				month--;
			}
		}
		acc.setPreviousTime(curTime);
		return month;
	}
	
}
