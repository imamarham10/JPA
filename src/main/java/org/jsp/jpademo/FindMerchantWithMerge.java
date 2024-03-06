package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FindMerchantWithMerge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Merchant m = new Merchant();
		m.setId(sc.nextInt());
		m.setName(sc.next());
		m.setEmail(sc.next());
		m.setGst_num(sc.next());
		m.setPhone_num(sc.nextLong());
		m.setPassword(sc.next());
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		manager.merge(m);
		EntityTransaction t = manager.getTransaction();
		t.begin();
		t.commit();
		sc.close();
	}
}
