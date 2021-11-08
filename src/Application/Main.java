package Application;



import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int option;
		do {
		System.out.println("Choose your preference: ");
		System.out.println("1- Use the Seller");
		System.out.println("2- Use the Department");
		System.out.println("0- Exit");
		
		option = sc.nextInt();
		
		switch (option) {
			case 1: {
				Seller();
				break;
			}
			case 2: {
				Department();
				break;
			}
			default:
				System.out.println();
				break;
			}
		}while(option != 0);
		
		System.out.println();
		System.out.println("Thank you!");
	
	}

	private static void Department() {
		MainDepartment md = new MainDepartment();
		md.mainDepartment();
		
	}

	private static void Seller() {
		MainSeller ms = new MainSeller();
		ms.mainSeller();
	}

}
