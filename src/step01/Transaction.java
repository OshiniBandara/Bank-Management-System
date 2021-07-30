package step01;

import java.util.Arrays;
import java.util.Scanner;

public class Transaction{
	
	
	public static void MoneyTran() {

		double tranAmoun = 0;
		String toTran;
		int toID;

		Scanner sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t \t According to Banking Security Your should login again");
		System.out.println("\t \t======================================================");
		System.out.println("\n Enter Your Bank Account Number again: ");
		int accNumber = sc.nextInt();
		System.out.println("\n Enter the PassWord:");
		String tempPassWord = sc.next();
		char[] password = tempPassWord.toCharArray();
		boolean valid1 = false;
		boolean valid = false;

		for (BankAccount b1 : BankAccount_Test.bankAccounts) {
			if (b1 != null) {

				if (accNumber == b1.getAccNumber() && Arrays.equals(password, b1.getPassWord())) {

					valid1 = true;

					System.out.println("\t ------------------------ ");
					System.out.println("\t USER ACCOUNT INFORMATION");
					System.out.println("\t ------------------------ ");
					System.out.println();
					System.out.println("Bank Account Number\t: " + b1.getAccNumber());
					System.out.println("Full Name\t: " + b1.getFirstName() + " " + b1.getLastName());
					System.out.println("User Last Name\t:" + b1.getLastName());
					System.out.println("");
					System.out.println("Bank Account Balance\t: " + b1.getAccBalance());
					System.out.println("\t ------------------------ ");
					System.out.println("");
					System.out.println("");


					System.out.println("Do You Want Transfer Money ... ? (Y/N)");
					String con = sc.next();

					selection:
					switch (con) {
						case "Y":

							System.out.println("This is your Current balance  :  Rs. " + b1.getAccBalance() + " /=");
							System.out.println("");
							System.out.println("");
							System.out.print("Insert amout that you want transfer :");
							tranAmoun = sc.nextDouble();
							System.out.println("");
							System.out.print("To Account Number :");
							toID = sc.nextInt();
							System.out.print("To Account First Name :");
							toTran = sc.next();
							System.out.println("");
							

							for (BankAccount b2 :BankAccount_Test.bankAccounts) {

								if (b2 != null) {

									if (toTran.equals(b2.getFirstName()) && toID == b2.getAccNumber()) {

										valid = true;

										System.out.println("\t ---------------------------- ");
										System.out.println("\t Transfer ACCOUNT INFORMATION");
										System.out.println("\t ---------------------------- ");
										System.out.println();
										System.out.println("Bank Account Number\t: " + b2.getAccNumber());
										System.out.println("Full Name\t: " + b2.getFirstName() + " " + b2.getLastName());
										System.out.println("User Last Name\t:" + b2.getLastName());
										System.out.println("");

										double val1 = (b1.getAccBalance() - tranAmoun);

										System.out.println("Do you want transfer $ " + tranAmoun + " for this account...?(Y/N)");
										String con1 = sc.next();

										if (con1.equals("y") || con1.equals("Y")) {

											if (val1 > 100.00) {
												b1.setAccBalance(b1.getAccBalance() - tranAmoun);
												b2.setAccBalance(b2.getAccBalance() + tranAmoun);


												System.out.println("");
												System.out.println("Your current Account Balance :  Rs." + b1.getAccBalance());
												System.out.println("Other account balance :  Rs." + b2.getAccBalance());
												System.out.println("");
												BankAccount_Test.saveData();
												BankAccount_Test.saveTem();
												System.out.println("Successful Transaction ... ");
												System.out.println("Thank you ...!");


											}
											if (val1 <= 99) {
												System.out.println("");
												System.out.println("Your account balance is less than Rs.100.00 if do this transfer!!");
												System.out.println("You cant transfer money...");
												System.out.println("Transaction  Failed ... !");
												System.out.println("");

											}
											if((b2.getAccBalance() + tranAmoun)>100000) {
												System.out.println("");
												System.out.println("WARNING!!!");
												System.out.println("transferring account balance is more than Rs.100000.00 if you do this transfer!!");
												
											}
										}
										if (con1.equals("n") || con1.equals("N")) {
											BankAccount_Test.SecondMenu();
											
										}

										
										System.out.println("Do you want to transfer $" +tranAmoun + " for this account? (Y/N)");
										String con2 = sc.next();
										
										if(con2.equals("y") || con2.equals("Y")) {
											System.out.println("Successfully transfered");
												
										}
										if(con2.equals("n") || con2.equals("N")) {
											
											
											b1.setAccBalance(b1.getAccBalance() + tranAmoun);
											b2.setAccBalance(b2.getAccBalance() - tranAmoun);
											
											System.out.println("");
											System.out.println("Your current Account Balance :  Rs." + b1.getAccBalance());
											System.out.println("Other account balance :  Rs." + b2.getAccBalance());
											System.out.println("");
										    BankAccount_Test.saveData();
											BankAccount_Test.saveTem();
											System.out.println("Successfully rolled back ");
											System.out.println("Thank you ...!");
											BankAccount_Test.SecondMenu();
										}
										
										


									}
									if (!valid) {
										System.out.println("\n \n Invalid Account number or Name");
										System.out.println("\t \t Please Recheck Account Number and Name...");
										System.out.println("");
									}

								}
							}

							break;// selection;

						case "N":
							
							BankAccount_Test.SecondMenu();
							break;// selection;
					}


				}
				if (!valid1) {
					System.out.println("\n \n Invalid Account number or password");
				}


			}

		}


	}



}
