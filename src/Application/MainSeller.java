package Application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class MainSeller {
	
	static Scanner sc = new Scanner(System.in);
	Seller seller = null;
	List<Seller> list;
	SimpleDateFormat sdf;
	SellerDao sellerDao = DaoFactory.createSellerDao();
	Department department;
	DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();
	List<Department> listD;
	Date date = null;
	public void mainSeller() {
		int option;
		do {
			System.out.println();
			System.out.println("what do you do with the seller?");
			System.out.println("1- Insert seller");
			System.out.println("2- Delete seller");
			System.out.println("3- Update seller");
			System.out.println("4- Find one seller");
			System.out.println("5- Find all sellers");
			System.out.println("0- exit");
			
			option = sc.nextInt();
			
			switch (option) {
				case 1: {
					Insert();
					break;
				}
				case 2: {
					Delete();
					break;
				}
				case 3: {
					Update();
					break;
				}
				case 4: {
					FindById();
					break;
				}
				case 5: {
					FindAll();
					break;
				}
			default:
				System.out.println("Type the correct option!");
				break;
			}
			
		}while(option != 0);
	}
	private void Insert() {
		System.out.println("Seller name: ");
		String name = sc.next();
		sc.nextLine();
		System.out.println("Seller Email: ");
		String email = sc.nextLine();
		System.out.println("birth date : *dd/MM/yyyy* ");
		String birthday = sc.next();
		System.out.println("Salary: ");
		Double salary = sc.nextDouble();
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sdf.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		listD = departmentDao.findAll();
		for(Department dep : listD) {
			System.out.println(dep);
		}
		System.out.println();
		System.out.println("Choose department by Id: ");
		int id = sc.nextInt();
		department = new Department(id, null);
		
		seller = new Seller(null, name, email, date, salary, department);
		sellerDao.insert(seller);
		System.out.println("Inserted New id: "+ seller.getId());
		
	}
	private void Delete() {
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
	}
	private void Update() {
		
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("Enter id for update test: ");
		int id = sc.nextInt();
		seller = sellerDao.fidnById(id);
		
		System.out.println("Do you wanto to Update the name? 1-yes / 2-not");
		int n = sc.nextInt();
		
		if(n == 1) {
			sc.nextLine();
			System.out.println("Seller name: ");
			String name = sc.nextLine();
			seller.setName(name);
		}
		 
		System.out.println("Do you wanto to Update the Email? 1-yes / 2-not");
		n = sc.nextInt();
		if(n == 1) {
			System.out.println("Seller Email: ");
			String email = sc.next();
			seller.setEmail(email);
		}
		System.out.println("Do you wanto to Update the birthday? 1-yes / 2-not");
		n = sc.nextInt();
		if(n == 1) {
			System.out.println("Seller birthday: ");
			String birthday = sc.next();
			sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				date = sdf.parse(birthday);
				seller.setBirthDate(date);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Do you wanto to Update the salary? 1-yes / 2-not");
		n = sc.nextInt();
		if(n == 1) {
			System.out.println("Seller salary: ");
			Double salary = sc.nextDouble();
			seller.setBaseSalary(salary);
		}
		
		
		sellerDao.update(seller);
		System.out.println("Update Completed");
	}
	private void FindById() {
		System.out.println("Enter id for find the seller: ");
		int id = sc.nextInt();
		seller = sellerDao.fidnById(id);
		
		System.out.println(seller);
		
		
	}
	private void FindAll() {
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println();
		
		
	}
	
}
