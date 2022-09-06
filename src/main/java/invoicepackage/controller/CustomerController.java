package invoicepackage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import invoicepackage.model.*;
import invoicepackage.services.*;
import java.util.*;
@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"*"})
public class CustomerController {

	@Autowired
	CustomerService cr;
	
	@GetMapping("/customer")
	public List<Customer>GetAllCustomer(){
		return cr.GetAllCustomers();
	}
	
	@GetMapping("/customer/{id}")
	public Customer GetCustomerById(@PathVariable("id") int id) {
		return cr.GetCustomerById(id);
	}
	
	@PostMapping("/customer")
	public String AddCustomers(@RequestBody Customer c) {
		cr.AddCustomer(c);
		return "Customer Added successfully";
	}
	
	@PutMapping("/customer")
	public String UpdateCustomers(@RequestBody Customer c) {
		cr.UpdateCustomer(c);
		return "Customer Updated Successfully";
	}
	
	@DeleteMapping("/customer/{id}")
	public String DeleteCustomer(@PathVariable("id") int id) {
		 cr.DeleteCustomer(id);
		 return "Customer Deleted Successfully";
	}
	
}
