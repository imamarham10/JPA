package org.jsp.jpademo;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindMerchantByGstNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Gst Num:");
		String gst_num = sc.next();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		Query q = manager.createQuery("select m from Merchant m where gst_num = ?1");
		q.setParameter(1, gst_num);
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
