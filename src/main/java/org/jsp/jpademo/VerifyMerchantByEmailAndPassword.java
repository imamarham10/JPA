package org.jsp.jpademo;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class VerifyMerchantByEmailAndPassword {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter Email:");
	String email = sc.next();
	System.out.println("Enter Password: ");
	String password = sc.next();
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m from Merchant m where email=?1 and password=?2");
	q.setParameter(1, email);
	q.setParameter(2, password);
	Merchant m = (Merchant)q.getSingleResult();
	try {
		System.out.println("Verification Successful!");
		System.out.println(m);
	}catch(NoResultException exp) {
		System.out.println("Verifaction Failed, invalid credentials");
	}
	sc.close();

}
}
