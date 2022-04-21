import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

// A class that implements the functions of an account into the banking application.

public class Account {
	
	private String name;
	private int balance;
	private String id;
	private ArrayList<String> transactionHistory;
	
	public Account(String name, String id) {
		this.name = name;
		this.id = id;
		this.balance = 0;
		this.transactionHistory = new ArrayList<>();
	}
	
	public void showMenu() {
		final String choices = "abcdef";
		Scanner sc = new Scanner(System.in);
		introduction();
		System.out.println("What would you like to do? ");
		System.out.println();
		showOptions();
		System.out.print("Enter choice: ");
		char choice = sc.next().charAt(0);
		while (choice != 'f') {
			choice = Character.toLowerCase(choice);
			if (choice == 'a') {
				System.out.println();
				getBalance();
			} else if (choice == 'b') {
				System.out.println();
				System.out.print("Enter amount: ");
				System.out.println();
				int amount = sc.nextInt();
				deposit(amount);
			} else if (choice == 'c') {
				System.out.println();
				System.out.print("Enter amount: ");
				System.out.println();
				int amount = sc.nextInt();
				withdraw(amount);
			} else if (choice == 'd') {
				System.out.println();
				getPrevTrans();
			} else if (choice == 'e') {
				System.out.println();
				System.out.print("Enter years: ");
				System.out.println();
				int years = sc.nextInt();
				getInterestRate(years);
			}
			System.out.print("What would you like to do? ");
			choice = sc.next().charAt(0);
		}
	}
	
	private void showOptions() {
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Check Previous Transactions");
		System.out.println("E. Calculate Interest");
		System.out.println("F. Exit");
		System.out.println();
	}
	
	private void introduction() {
		System.out.println("Welcome, " + this.name + "!");
		System.out.println("Account ID: " + this.id);
		System.out.println();
	}
	
	private void getBalance() {
		System.out.println("===================================");
		System.out.println("Balance: $" + this.balance);
		System.out.println("===================================");
		System.out.println();
	}
	
	private void deposit(int amount) {
		if (amount > 0) {
			this.balance += amount;
			System.out.println("===================================");
			System.out.println("New Balance: $" + this.balance);
			System.out.println("===================================");
			transactionHistory.add("+" + amount);
			System.out.println();
		}
	}
	
	private void withdraw(int amount) {
		if (amount < this.balance) {
			this.balance -= amount;
			System.out.println("===================================");
			System.out.println("New Balance: $" + this.balance);
			System.out.println("===================================");
			transactionHistory.add("-" + amount);
			System.out.println();
		} else {
			System.out.println("Insufficient Funds");
			System.out.println();
		}
	}
	
	private void getPrevTrans() {
		if (transactionHistory.size() > 0) {
			Iterator<String> it = this.transactionHistory.iterator();
			while (it.hasNext()) {
				System.out.println(it.next());
			}
			System.out.println();
		} else {
			System.out.println("No Previous Transactions");
			System.out.println();
		}
	}
	
	private void getInterestRate(int years) {
		double interestRate = 1.0185;
		double newBalance = balance * interestRate * years;
		System.out.println("Current Interest Rate: " + interestRate + "%");
		System.out.println();
		System.out.println("===================================");
		System.out.println("Your Balance in " + years + " years will be: $" + newBalance);
		System.out.println("===================================");
		System.out.println();
	}
	
	

}
