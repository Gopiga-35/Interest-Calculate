package com.wipro.bank.service;
import com.wipro.bank.acc.RDAccount;
import com.wipro.bank.exception.BankValidationException;
public class BankService {
    public boolean validateData(float principal,int tenure,int age,String gender)
    {
    	try {
    		if(principal < 500)
    		{
    			System.out.println("Principal should be minimum 500");
    			throw new BankValidationException();
    		}
    		if(!(tenure ==5 || tenure ==10))
    		{
    			System.out.println("Tenure must be either 5 or 10 only");
    			throw new BankValidationException();
    		}
    		if(!(gender.equalsIgnoreCase("Female")|| gender.equalsIgnoreCase("Male")))
    		{
    			System.out.println("Gender shoud be male or female");
    			throw new BankValidationException();
    		}
    		if(age < 1 && age > 100)
    		{
    			System.out.println("Age must be between 1 to 100");
    			throw new BankValidationException();
    		}
    		return true;
    	}
    	catch(BankValidationException e)
    	{
    		System.out.println(e);
    		return false;
    	}
    }
    public void calculate(float principal,int tenure,int age,String gender)
    {
    	if(validateData(principal,tenure,age,gender))
    	{
    		RDAccount rd=new RDAccount(tenure,principal);
    		rd.setInterest(age, gender);
    		float Interest =rd.calculateInterest();
    		System.out.println("Interest:"+Interest);
    		float AmountDeposited =rd.calculateAmountDeposited();
    		System.out.println("Deposited Amount:"+AmountDeposited);
    		float MaturityAmount =rd.calculateMaturityAmount(AmountDeposited,Interest);
    		System.out.println("Maturity Amount:"+MaturityAmount);
    	}
    	else
    	{
    		System.out.println("Calculation aborted due to invalid data");
    	}
    }
}