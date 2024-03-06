package org.jsp.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindAllGstNumbers {
public static void main(String[] args) {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
	EntityManager manager = factory.createEntityManager();
	Query q = manager.createQuery("select m.gst_num from Merchant m");
	List<String>gstList = q.getResultList();
	if(gstList.size()>0) {
		for(String data: gstList) {
			System.out.println(data);
		}
	}else {
		System.out.println("No record found!");
	}
}
}
