package step01;

import java.io.Serializable;

public class BankAccount implements Serializable{
	
	

	private int accNumber;
	private double accBalance;
	private String firstName;
	private String lastName;
	private char[] passWord;
	private String bsbNumber;
	private String address;
	private String postCode;
	private String branch;
	private int widrowMoney;
	private int depositMoney;
	private double MonthlyFee;
	private int NumberOfChecks;


	public BankAccount(int accNumber, double accBalance, String firstName, String lastName, String bsbNumber, String address, String postCode, String branch ,double MonthlyFee, int NumberOfChecks, char[] passWord) {
		super();
		this.accNumber = accNumber;

		this.accBalance=accBalance;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passWord = passWord;
		this.bsbNumber = bsbNumber;
		this.address = address;
		this.postCode = postCode;
		this.branch = branch;
		this.MonthlyFee= MonthlyFee;
		this.NumberOfChecks = NumberOfChecks;
		setAccNumber(accNumber);
		setAccBalance(accBalance);
		setFirstName(firstName);
		setLastName(lastName);
		setPassWord(passWord);
		setBsbNumber(bsbNumber);
		setAddress(address);
		setPostCode(postCode);
		setBranch(branch);
		setMonthlyFee(MonthlyFee);
		setNumberOfChecks(NumberOfChecks);

		
	}





	




	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public char[] getPassWord() {
		return passWord;
	}


	public int getAccNumber() {
		return accNumber;
	}


	public double getAccBalance() {
		return accBalance;
	}


	public void setAccNumber(int accNumber) {
		this.accNumber = accNumber;
	}


	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setPassWord(char[] passWord) {
		this.passWord = passWord;
	}

	public String getBsbNumber(){ return  bsbNumber;}

	public String getAddress(){ return  address;}

	public String getPostCode(){ return  postCode;}

	public String getBranch(){ return  branch;}

	public void setBranch(String branch){
		this.branch = branch;
	}

	public void setBsbNumber(String bsbNumber){
		this.bsbNumber = bsbNumber;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setPostCode(String postCode){
		this.postCode = postCode;
	}
	
	public double getMonthlyFee() {
		return MonthlyFee;
	}
	public int getNumberOfChecks() {
		return NumberOfChecks;
	}
	public void setMonthlyFee(double monthlyFee) {
		this.MonthlyFee=MonthlyFee;
	}
	public void setNumberOfChecks(int numberOfChecks) {
		this.NumberOfChecks = NumberOfChecks;
	}



	@Override
	public String toString() {
		return "ID : " + getAccNumber() +" Name : "+ getFirstName() +" "+ getLastName()+" Password : "+getPassWord()+" Account Balence : " + getAccBalance();
	}











}