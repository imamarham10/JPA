package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SaveMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		System.out.println("Enter gst_num");
		System.out.println("Enter email");
		System.out.println("Enter phone");
		System.out.println("Enter password");

		Merchant m = new Merchant();
		m.setName(sc.next());
		m.setGst_num(sc.next());
		m.setEmail(sc.next());
		m.setPhone_num(sc.nextLong());
		m.setPassword(sc.next());

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		manager.persist(m);
		EntityTransaction t = manager.getTransaction();
		t.begin();
		t.commit();
		sc.close();
	}
}
