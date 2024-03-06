package org.jsp.jpademo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@NamedQueries(value = {
		@NamedQuery(name="verifyMerchantWithEmailAndPassword", query = "select m from Merchant m where email=?1 and password=?2"),
		@NamedQuery(name="findNames", query= "select m.name from Merchant m")
})
@Entity
@Table(name="Merchant")
public class Merchant {
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", gst_num=" + gst_num + ", email=" + email + ", phone_num="
				+ phone_num + ", password=" + password + "]";
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false, unique = true)
	private String gst_num;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private long phone_num;
	@Column(nullable = false)
	private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGst_num() {
		return gst_num;
	}
	public void setGst_num(String gst_num) {
		this.gst_num = gst_num;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone_num() {
		return phone_num;
	}
	public void setPhone_num(long phone_num) {
		this.phone_num = phone_num;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
