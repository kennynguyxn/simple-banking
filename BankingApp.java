import java.util.Scanner;

// Create a banking application that greets users and performs regular banking functions using Java.

public class BankingApp {
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		String name = getName(sc);
		String id = getID(sc);
		Account kenny = new Account(name, id);
		System.out.println();
		kenny.showMenu();
	}
	
	private static String getName(Scanner sc) {
		System.out.print("Account Name: ");
		String name = sc.nextLine();
		return name;
	}
	
	private static String getID(Scanner sc) {
		System.out.print("Account ID: ");
		String id = sc.nextLine();
		return id;
	}
}
