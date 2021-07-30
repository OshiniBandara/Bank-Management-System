 package step01;
import javax.xml.bind.SchemaOutputResolver;
import java.io.*;
import java.util.Scanner;
import java.util.*;

public class BankAccount_Test {

	static int count = 0;
	static List<BankAccount> bankAccounts = new ArrayList<BankAccount>();

	
	Scanner sc = new Scanner(System.in);
	private double MonthlyFee;
	private int NumberOfChecks;
	public static double value;
	

	public static double interestBalance;

	public static double deposit;

	public static double withdrawal1;

	public static int years;


	public static void main(String[] args) throws IOException {
		
		BankAccount_Test bat = new BankAccount_Test();
		bat.dataPersistency();
		Transaction tr =new Transaction();
		CheckingAccount ch = new CheckingAccount();
	
		CheckingAccountWithInterest cheacc= new CheckingAccountWithInterest(); 
		Scanner sc = new Scanner(System.in);
		char input1 = '\0';


		try {
			while (input1 != '0') {

				System.out.println("\t \t =====================================");
				System.out.println("\t \t \t BANK SYSTEM - MAIN MENU ");
				System.out.println("\t \t =====================================");
				System.out.println("");
				System.out.println(" '1' - Enter for login to your account");
				System.out.println(" '2' - Enter for create a savings account");
				System.out.println(" '3' - Enter for create a checking account");
				System.out.println(" '4' - Enter for create a checking account with interest account");
				System.out.println(" '5' - Existing Account Details");
				System.out.println(" '0' to Exit ");
				System.out.println();
				System.out.println();
				System.out.print("Enter your choice : ");
				input1 = sc.next().charAt(0);

				selection:
				switch (input1) {
					case '1':
						bat.Login();
						break;// selection;
					case '2':
						SavingsAccount.SavingsAccount();
						break;
					case '3':
						ch.CheckingAccount();
						break;
					case '4':
						cheacc.CheckingAccountWithInterest();
						break;// selection;
					case '5':
						bat.getAccDetails();
						break;// selection;
					case '0':
						bat.saveData();
						System.out.println("EXIT....!");
						ProduceReport();
						System.exit(0);
						sc.close();
						break;// selection;


				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	//Account details and loging part
	public static void Login() {

		Scanner sc1 = new Scanner(System.in);
		System.out.println("\t \t =====================================");
		System.out.println("01. \t Enter your user Acc First Name	:");
		String firstName = sc1.nextLine();

		System.out.println("02. \t Enter your password	:");
		String passWord = sc1.nextLine();
		char[] password = passWord.toCharArray();
		boolean valid = false;


		for (BankAccount v2 : bankAccounts) {
			if (v2 != null) {
			
				if (firstName.equals(v2.getFirstName()) && Arrays.equals(password, v2.getPassWord())) {
					valid = true;
					System.out.println("\t \t =====================================");
					System.out.println("\t \t \t \t   Login Success");
					System.out.println("\t \t =====================================");
					System.out.println();
					System.out.println("\t \t \t \t Your Account Details");
					System.out.println();
					System.out.println("Bank Account Number\t: " + v2.getAccNumber());
					System.out.println("Full Name\t: " + v2.getFirstName() + " " + v2.getLastName());
					System.out.println("Bank Account Balance\t: " + v2.getAccBalance());
					System.out.println("User BSB Number\t: " + v2.getBsbNumber());
					System.out.println("User Home Address\t: " + v2.getAddress());
					System.out.println("User Postal Code\t: " + v2.getPostCode());
					System.out.println("");
					System.out.println("\t \t =====================================");
					SecondMenu();


				} else {
					System.out.println("\t \t =====================================");
				}

			}
		}
		if (!valid) {
			System.out.println("Login Faild... There is not any Account Information.");
			System.out.println("\n \n Invalid Account number or password");
		}

	}
	
	public void Login1() {

		Scanner sc1 = new Scanner(System.in);
		System.out.println("\t \t =====================================");
		System.out.println("01. \t Enter your user Acc First Name	:");
		String firstName = sc1.nextLine();

		System.out.println("02. \t Enter your password	:");
		String passWord = sc1.nextLine();
		char[] password = passWord.toCharArray();
		boolean valid = false;


		for (BankAccount v2 : bankAccounts) {
			if (v2 != null) {
			
				if (firstName.equals(v2.getFirstName()) && Arrays.equals(password, v2.getPassWord())) {
					valid = true;
					System.out.println("\t \t =====================================");
					System.out.println("\t \t \t \t   Login Success");
					System.out.println("\t \t =====================================");
					System.out.println();
					System.out.println("\t \t \t \t Your Account Details");
					System.out.println();
					System.out.println("Bank Account Number\t: " + v2.getAccNumber());
					System.out.println("Full Name\t: " + v2.getFirstName() + " " + v2.getLastName());
					System.out.println("Bank Account Balance\t: " + v2.getAccBalance());
					System.out.println("User BSB Number\t: " + v2.getBsbNumber());
					System.out.println("User Home Address\t: " + v2.getAddress());
					System.out.println("User Postal Code\t: " + v2.getPostCode());
					System.out.println("Your monthly fee =" +v2.getMonthlyFee() );
					System.out.println("Your Number of checks =" +v2.getNumberOfChecks() );
					
					System.out.println("");
					System.out.println("\t \t =====================================");
					SecondMenu1();


				} else {
					System.out.println("\t \t =====================================");
				}

			}
		}
		if (!valid) {
			System.out.println("Login Faild... There is not any Account Information.");
			System.out.println("\n \n Invalid Account number or password");
		}

	}
	
	
	
	public static void SecondMenu1() {

		Scanner sc1 = new Scanner(System.in);
		for (BankAccount v2 : bankAccounts) {
			if (v2 != null) {


				System.out.println("\t \t \t \t   Choose What you want");
				System.out.println("\t \t =====================================");
				System.out.println(" 'A' - View account details");
				System.out.println(" 'B' - Money transfer");
				
				System.out.println(" '0' - EXIT");
				System.out.println("");
				System.out.print("01. Enter your Selection \t: ");
				String UI1 = sc1.nextLine();

				selection:
				switch (UI1) {
					case "A":
						displayAccount();
						break;
					case "B":
						Transaction.MoneyTran();
						
						break;
					
					case "0":
						System.out.println("Thank You...!");
						ProduceReport();
						System.exit(0);
						break;
				}

			}
		}

	}


	public static  void SecondMenu() {

		Scanner sc1 = new Scanner(System.in);
		for (BankAccount v2 : bankAccounts) {
			if (v2 != null) {


				System.out.println("\t \t \t \t   Choose What you want");
				System.out.println("\t \t =====================================");
				System.out.println(" 'A' - View account details");
				System.out.println(" 'B' - Money transfer");
				System.out.println(" 'C' - Bank interest,Deposit,withdrawal");
				System.out.println(" '0' - EXIT");
				System.out.println("");
				System.out.print("01. Enter your Selection \t: ");
				String UI1 = sc1.nextLine();

				selection:
				switch (UI1) {
					case "A":
						displayAccount();
						break;
					case "B":
						Transaction.MoneyTran();
						
						break;
						
					case "C":
						try {
							SavingsAccount.computeInterest();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case "0":
						System.out.println("Thank You...!");
						ProduceReport();
						System.exit(0);
						break;
				}

			}
		}

	}


	public static  void displayAccount() {

		for (BankAccount v3 : bankAccounts) {
			if (v3 != null) {

				System.out.println("\t ------------------------ ");
				System.out.println("\t USER ACCOUNT INFORMATION");
				System.out.println("\t ------------------------ ");
				System.out.println();
				System.out.println("Bank Account Number\t: " + v3.getAccNumber());
				System.out.println("Full Name\t: " + v3.getFirstName() + " " + v3.getLastName());
				System.out.println("User Last Name\t:" + v3.getLastName());
				System.out.println("");
				System.out.println("User BSB Number\t: " + v3.getBsbNumber());
				System.out.println("User Home Address\t: " + v3.getAddress());
				System.out.println("User Postal Code\t: " + v3.getPostCode());
				System.out.println("Bank Account Balance\t: " + v3.getAccBalance());
				System.out.println("Current Password\t:" + v3.getPassWord());
				System.out.println("Sorry..! Here Password has encrypted");
				System.out.println("");
				System.out.println("\t ------------------------ ");
				System.out.println("");
				System.out.println("");

				SecondMenu();
			}

		}
	}



	public static void dataPersistency() {
		try {

			FileInputStream fis = new FileInputStream("Data.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			bankAccounts = (List<BankAccount>) ois.readObject();
		} catch (Exception e) {

		}
	}

	public static void saveData() {
		try {
			FileOutputStream fos = new FileOutputStream("Data.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(bankAccounts);
		} catch (Exception e) {

		}

	}

	public static void saveTem() {
		try {

			File f1 = new File("Bank.txt");
			FileWriter fw1 = new FileWriter(f1);
			BufferedWriter bw1 = new BufferedWriter(fw1);

			// bw1.write();
			for (BankAccount v2 : bankAccounts) {

				if (v2 != null) {
					bw1.write(v2.toString());
					bw1.newLine();
				}
			}
			bw1.close();

		} catch (IOException ioe) {

		}
	}

	public void getAccDetails() {

		System.out.println("Account Num \t \t Full Name ");
		System.out.println("-------------------------------------------");
		for (BankAccount v : bankAccounts) {
			if (v != null) {

				System.out.println(
						v.getAccNumber() + "\t \t \t" + v.getFirstName() + " " + v.getLastName());


			}
		}

		System.out.println("-------------------------------------------");
	}
	
	public static void ProduceReport() {
		System.out.println("\t \t=========================== ");
		System.out.println("\t \t USER ACCOUNT INFORMATION");
		System.out.println("\t \t=========================== ");
		System.out.println("\t \t--------REPORT-------------");
		
		
		 System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		    System.out.printf("%10s %20s %20s %20s %10s %20s ", "ACCOUNT NUMBER", "ACCOUNT BALANCE", "FIRST NAME", "LAST NAME", "BRANCH", "ADDRESS");
		    System.out.println();
		    System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		    for(BankAccount st: bankAccounts){
		        System.out.format("%10s %20s %20s %20s %10s %20s ",
		                st.getAccNumber(), st.getAccBalance(), st.getFirstName(), st.getLastName(), st.getBranch(),st.getAddress());
		        System.out.println();
		    }
		    System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		    System.out.println("\t \t=========================== ");
			System.out.println("\t \t*****END OF THE REPORT*****");
			System.out.println("\t \t=========================== ");
		
		
		
		
	}


}