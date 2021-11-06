package Application;



import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		
		Department obj = new Department(2,"books");
		System.out.println(obj);
		
		Seller seller = new Seller(21,"bob","bob@hot",new Date(), 3000.0, obj);
		System.out.println(seller);
	}

}
