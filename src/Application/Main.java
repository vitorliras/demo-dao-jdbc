package Application;



import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST 1: seller FindById ===");
		Seller seller = sellerDao.fidnById(3);
		
		System.out.println(seller);
		System.out.println();
		
		System.out.println("=== TEST 2: seller FindByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 3: seller FindAll ===");
		list = sellerDao.findAll();
		
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println();
		
		System.out.println("=== TEST 4: seller Insert ===");
		Seller s = new Seller(null, "Greg fallout", "greg@hotmail.com", new Date(), 4000.0,department);
		sellerDao.insert(s);
		System.out.println("Inserted New id: "+ s.getId());
	
		System.out.println();
		
		System.out.println("=== TEST 5: seller Update ===");
		seller = sellerDao.fidnById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update Completed");
	
		System.out.println();
		
		System.out.println("=== TEST 6: seller Delete ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		System.out.println();
		System.out.println("----------DEPARTMENT----------");
		System.out.println();
		
		System.out.println("=== TEST 7: department insert ===");
		DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();
		List<Department> listD;
		Department d = new Department(null, "accessories");
		departmentDao.insert(d);
		System.out.println("Inserted New id: "+d.getId());
		
		
		System.out.println();
		System.out.println("=== TEST 8: department findById ===");
		d = departmentDao.fidnById(2);
		System.out.println(d);

		System.out.println();
		System.out.println("=== TEST 9: department findAll ===");
		listD = departmentDao.findAll();
		for(Department dep : listD) {
			System.out.println(dep);
		}
	
	}

}
