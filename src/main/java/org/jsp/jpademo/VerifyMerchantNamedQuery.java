package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantNamedQuery {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter email and password");
		String email = sc.next();
		String password = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createNamedQuery("verifyMerchantWithEmailAndPassword");
		q.setParameter(1, email);
		q.setParameter(2, password);
		try {
			Merchant m = (Merchant)q.getSingleResult();
			System.out.println(m);
		}catch(NoResultException exp) {
			System.err.println("Invalid Email or Password");
		}finally {
			sc.close();
		}
	}
}
