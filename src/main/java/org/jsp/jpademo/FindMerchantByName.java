package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByName {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name:");
		String name = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m from Merchant m where name = ?1");
		q.setParameter(1, name);
		List<Merchant> list = q.getResultList();
		if(list.size()>0) {
			for(Merchant n : list) {
				System.out.println(n);
			}
		}else {
			System.out.println("No result found!");
		}
	}
}
