package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id:");
		int id = sc.nextInt();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		Merchant a = manager.find(Merchant.class, id);
		if(a!=null) {
			a.setName("Arham Imam");
			a.setEmail("arham@admin.com");
			a.setGst_num("arham1233444");
			a.setPhone_num(789456123L);
			a.setPassword("arham@123");
			t.begin();
			t.commit();
		}
	}
}
