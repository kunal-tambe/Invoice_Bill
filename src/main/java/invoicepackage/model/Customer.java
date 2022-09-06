package invoicepackage.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;

@Entity
@Table(name = "tblcustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id;
	private String customer_name;
	private String email;
	private String mobile;
	private String password;
	private String city;
	
	@OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("customer")

	private List<InvoiceDetail> invoicedetails;
	
	
	

	public Customer(int customer_id, String customer_name, String email, String mobile, String password, String city) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.city = city;
	}



	

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<InvoiceDetail> getInvoicedetails() {
		return invoicedetails;
	}

	public void setInvoicedetails(List<InvoiceDetail> invoicedetails) {
		this.invoicedetails = invoicedetails;
	}

	public Customer(int customer_id, String customer_name, String email, String mobile, String password, String city,
			List<InvoiceDetail> invoicedetails) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.email = email;
		this.mobile = mobile;
		this.password = password;
		this.city = city;
		this.invoicedetails = invoicedetails;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
