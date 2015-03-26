public class Bank {
    
    public String name;
    public String password;
    public int pin;
    public long accountNumber;
    public double balance;
   
    //Constructor
    public Bank(String n, String pass, int p, long num, double b) {
	name = n;
	password = pass;
	pin = p;
	accountNumber = num;
	balance = b;
    }

    //Basic Set Account Info Methods
    public void setName(String n) {
	name = n;
    }

    public void setPass(String p) {
	password = p;
    }

    public void setPin(int p) {
	if (p >= 1000 && p <= 9998) {
	    pin = p;
	}
	else {
	    pin = 9999;
	    System.out.println( "PIN Invalid, please input a four digit number!" );
	}
    }

    public void setAccountNum(long num) {
	if (num >= 100000000 && num <= 999999998) {
	    accountNumber = num;
	}
	else {
	    accountNumber = 999999999;
	    System.out.println( "Account Number Invalid, please input a nine digit number!" );
	}
    }

    public void setBalance(double b) {
	balance = b;
    }

    //Account Information
    public void printAccountInfo() {
	System.out.println(name);
	System.out.println(password);
	System.out.println(pin);
	System.out.println(accountNumber);
	System.out.println(balance);
    }
    
    //Account Actions
    public void deposit(double depositAmount) {
	balance += depositAmount;
    }

    public boolean withdraw(double withdrawAmount) {
	if (balance >= withdrawAmount) {
	    balance -= withdrawAmount;
	    return true;
	}
	else {
	    System.out.println( "You do not have enough money in your account!" );
	    return false;
	}         
    }
    
    public boolean login(long accountNum, String pswd) {
        return  (accountNum == accountNumber && pswd == password);
    }

    //Main
    public static void main(String[] args) {
	Bank myAccount = new Bank("Samuel Zhang", "Ubuntu", 1234, 123456789, 777);
	
	//Prints Original Account Info
	myAccount.printAccountInfo();
	
	//Change Account Info And Balance
	myAccount.setName("Samuel Ubuntu Zhang");
	myAccount.setPass("Linux");
	myAccount.setPin(5678);
	myAccount.setAccountNum(345678901);
	myAccount.setBalance(1337);
	myAccount.deposit(1);
	
	System.out.println();

	//Prints Changed Account Info
	myAccount.printAccountInfo(); //Balance should = 1338
	
	System.out.println();

	//Test Withdraw
	myAccount.withdraw(2);
	myAccount.withdraw(10000); //Tests the legitimacy of withdraw method to avoid crime
       
	//Prints out Withdrawal Info
	myAccount.printAccountInfo(); //Balance should = 1336

	//Tests Login
	System.out.print("Should be true: ");
	System.out.println(myAccount.login(345678901, "Linux")); //Should be true!

	System.out.print("Should be false: ");
	System.out.println(myAccount.login(123456789, "Linux")); //Should be false!

	//Tests Set Pin and Account Number Methods
	myAccount.setPin(123);
	myAccount.setAccountNum(12234);
    }
}
