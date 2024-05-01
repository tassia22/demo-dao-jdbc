package application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.creatSellerDao();
		
		System.out.println("=== test 1: seller findById ====");
		
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n=== test 2: seller findByDepartment ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== test 3: seller findAll ====");
	    list = sellerDao.findAll();
	    for(Seller obj: list) {
			System.out.println(obj);
		}
	    
	    System.out.println("\n=== test 4: seller insert ====");
	    Seller newSeller = new Seller(null, "greg", "greg@gmail.com", new Date(), 4000.0, department);
	    sellerDao.insert(newSeller);
	    System.out.println("Imserted new id = "+newSeller.getId());
	    
	    System.out.println("\n=== test 5: seller update ====");
	    seller = sellerDao.findById(1);
	    seller.setName("marta silva");
	    sellerDao.update(seller);
	    System.out.println("update cmompleted");
	    
	    System.out.println("\n=== test 6: seller delete ====");
	    System.out.println("digite um codigo id para o teste de delete");
	    int id = scan.nextInt();
	    sellerDao.deleteById(id);
	    System.out.println("delete completed");
	    
	    scan.close();
	}

}
