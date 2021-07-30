package step01;

import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class CheckingAccountWithInterest extends BankAccount_Test  {

	private  double interestRate1;
	private double MonthlyFee;
	private int NumberOfChecks;

	public void CheckingAccountWithInterest() {
		
			System.out.println("\t \t =====================================");
			System.out.println("\t \t NEW BANK ACCOUNT - ENTER YOUR DETAILS");
			System.out.println("\t \t =====================================");


			

			if (bankAccounts.size()<=5)
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
						Login();
						break;
					case "y":
						Login();
						break;
				}
			}
			
			}else{
			
			System.out.println("You can't create anymore accounts!");	
			}
			
		
		
		
	}
	
	
	public  void computeInterest() throws IOException {

		BankAccount acc1 = null;

		Scanner sc = new Scanner(System.in);
		System.out.println("\n \n Enter the Bank Account Number: ");
		int accNumber = sc.nextInt();
		System.out.println("\n Enter the Pass Word:");
		String tempPassWord = sc.next();
		char[] password = tempPassWord.toCharArray();
		boolean valid = false;
		
		for (BankAccount obj : bankAccounts) {
			if (obj.getAccNumber() == accNumber && Arrays.equals(password, obj.getPassWord())) {
				acc1 = obj;
				valid = true;
				System.out.println("Bank account number:" + accNumber);
				System.out.println("Bank Account Balance:" + obj.getAccBalance());

			}

		}
		if (!valid) {
			System.out.println("\n \n Invalid Account number or password");
		}

	if (valid) {

		
		interestRate1=0.02;
		
		
			interestBalance = (acc1.getAccBalance() * interestRate1 / 100) + acc1.getAccBalance();

			if ((interestBalance > 100000) || (interestBalance < 0)) {
				System.out.println("you can't add interest to your account");
				interestBalance = acc1.getAccBalance();
			}


			do {
				Scanner input3 = new Scanner(System.in);
				System.out.print("Enter the years of interest between 1-40: ");
				years = input3.nextInt();


			}while(!(years<1)&&(years>40));






			Scanner input1 = new Scanner(System.in);
			System.out.print("Enter the deposit amount: ");
			deposit = input1.nextDouble();


			Scanner input2 = new Scanner(System.in);
			System.out.print("Enter the withdrawal amount: ");
			withdrawal1 = input2.nextDouble();


			Date dt = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime(dt);
			double sBal = acc1.getAccBalance(), eBal;

			for (int i = 0; i <= years; i++) {
				
				sBal = sBal + sBal * interestRate1 / 100;
				eBal = (sBal - withdrawal1) + deposit;
			
				c.add(Calendar.YEAR, 1);
				int y = c.get(Calendar.YEAR);
				System.out.println("- Year-" + y + "-Final Balance  =" + eBal);
				sBal = eBal;
			}

		}

	}

	

}
