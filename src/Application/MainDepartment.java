package Application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class MainDepartment {
	static Scanner sc = new Scanner(System.in);
	DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();
	Department department;
	List<Department> list;
	
	public void mainDepartment() {
		
		int option;
		
		do {
			System.out.println();
			System.out.println("what do you do with the department?");
			System.out.println("1- Insert department");
			System.out.println("2- Delete department");
			System.out.println("3- Update department");
			System.out.println("4- Find one department");
			System.out.println("5- Find all departments");
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
		System.out.println("Enter the department name");
		String name = sc.nextLine();
		department = new Department(null, name);
		departmentDao.insert(department);
		System.out.println("Inserted New id: "+department.getId());
		
		
	}

	private void Delete() {
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
	}

	private void Update() {
		System.out.println("Do you really want to update the name department? 1-Yes/ 2-No");
		int n = sc.nextInt();
		if(n == 1) {
			System.out.println("Enter new the department name: ");
			String name = sc.next();
			System.out.println("Enter id for update: ");
			int id = sc.nextInt();
			department = departmentDao.fidnById(id);
			department.setName(name);
			departmentDao.update(department);
			System.out.println("Update Completed");
		}else {
			System.out.println("No Update");
		}
	}

	private void FindById() {
		System.out.println("Enter if for find: ");
		int id3 = sc.nextInt();
		department = departmentDao.fidnById(id3);
		System.out.println(department);
		
	}

	private void FindAll() {
		list = departmentDao.findAll();
		for(Department dep : list) {
			System.out.println(dep);
		}
		
	}

	
	
}
