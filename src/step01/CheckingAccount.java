package step01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class CheckingAccount extends BankAccount_Test {
	

	CheckingAccountWithInterest cheacc= new CheckingAccountWithInterest(); 

	
	private static double MonthlyFee;
	private static int NumberOfChecks;

	
	public void CheckingAccount() {
		
		System.out.println("\t \t =====================================");
		System.out.println("\t \t NEW BANK ACCOUNT - ENTER YOUR DETAILS");
		System.out.println("\t \t =====================================");


		

		if (bankAccounts.size()<=10)
		{
			int accNumber=(new Random().nextInt (9999-1000) +1000);
			System.out.println("\n your account Number	: " +accNumber);
		
		
		
		

	
			
			double accBalance;
			do {
				System.out.println("\n Input account balance :");
				accBalance = sc.nextDouble();
				
				if((accBalance < 0)||(accBalance >100000)) {
					System.out.println(" Enter valid balance for your account between $0-$100000");
					System.out.println("Invalid balance");
				}
				
				
			}while((accBalance <0)||(accBalance >100000)) ;
		System.out.println("\n Enter the First Name: ");
		String firstName = sc.next();

		System.out.println("\n  Enter the last name: ");
		String lastName = sc.next();
		
		System.out.println("\n  Enter the BSB Number: ");
		String bsbNumber = sc.next();
		
		System.out.println("\n  Enter the Address: ");
		String address = sc.next();
		
		System.out.println("\n  Enter the post code: ");
		String postCode = sc.next();


		System.out.println("\n  Enter the Branch name: ");
		String branch = sc.next();
		
		System.out.println("Enter your monthly fee:" +MonthlyFee);
		 MonthlyFee=sc.nextDouble();
		 
		 System.out.println("Enter your Number of cheques:" +NumberOfChecks);
		 NumberOfChecks= sc.nextInt();
		 

		System.out.println("\n Enter New PassWord:");
		String tempPassWord = sc.next();
		char[] password = tempPassWord.toCharArray();

		System.out.println("\n Confirm your PassWord:");
		String confPassWord = sc.next();
		char[] password1 = confPassWord.toCharArray();

		if (Arrays.equals(password, password1)) {

			BankAccount newAccount = new BankAccount(accNumber, accBalance, firstName, lastName, bsbNumber, address , postCode, branch, MonthlyFee, NumberOfChecks, password1);
			bankAccounts.add(newAccount);
			saveTem();
			//bankAccounts[count++] = new BankAccount(accNumber,accBalance,firstName,lastName,password);
			System.out.println("\n \n Successfully created the new account");
			System.out.println("");
			System.out.println("Do you want login to your own account ...? (Y/N)");
			String in = sc.next();

			switch (in) {
				case "Y":
					Login1();
					break;
				case "y":
					Login1();
					
					break;
			}
		}
		
		}else{
		
		System.out.println("You can't create anymore accounts!");	
		}
		
	
	
	
}
		
		

	
}
