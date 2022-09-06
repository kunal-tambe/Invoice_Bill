package invoicepackage.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import invoicepackage.model.*;
import java.util.*;
import invoicepackage.repository.*;

@Service
@Transactional
public class CustomerService {

	@Autowired
	CustomerRepository cr;

	public List<Customer> GetAllCustomers(){
	   List<Customer>lst= cr.findAll();
	   List<Customer>lst1=new ArrayList<Customer>();
	   for (Customer c :lst) {
	 c.setInvoicedetails(null);
	 lst1.add(c);
		
	}
	   return lst1;
	}
	
	public Customer GetCustomerById(Integer id) {
		return cr.findById(id).get();
	}
	
	public void AddCustomer(Customer c) {
		cr.save(c);
	}
	

	public void UpdateCustomer(Customer c) {
		cr.save(c);
	}
	
	public void DeleteCustomer(Integer id) {
		cr.deleteById(id);
	}
}
