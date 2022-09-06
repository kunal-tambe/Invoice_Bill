package invoicepackage.controller;
import invoicepackage.model.*;
import invoicepackage.services.*;
import java.util.*;

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


@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"*"})
public class InvoicePaymentController {

	@Autowired
	InvoicePaymentService pr;
	
	@GetMapping("/payment")
	public List<InvoicePayment>GetAllPayments(){
		return pr.GetAllPayments();
	}
	
	@GetMapping("/payment/{id}")
	public InvoicePayment GetPaymentsById(@PathVariable("id") int id) {		
		System.out.println(id);
		return pr.GetPaymentById(id);	
	}
	
	@PostMapping("/payment")
	public String AddPayments(@RequestBody InvoicePayment c) {
		pr.AddPayment(c);
		return "Payment Added successfully";
	}
	
	@PutMapping("/payment")
	public String UpdatePayment(@RequestBody InvoicePayment c) {
		pr.UpdatePayment(c);
		return "Payment Updated Successfully";
	}
	
	@DeleteMapping("/payment/{id}")
	public String DeletePayment(@PathVariable("id") int id) {
		 pr.DeletePayment(id);
		 return "Payment Deleted Successfully";
	}

}
