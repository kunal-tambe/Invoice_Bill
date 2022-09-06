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
@CrossOrigin
(origins = "*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowedHeaders = {"*"})
public class InvoiceDetailController {

	@Autowired
	InvoiceDetailService ds;
	
	@GetMapping("/detail")
	public List<InvoiceModel>GetAllInvoices(){
		return ds.GetAllInvoiceDetails();
	}
	
	@GetMapping("/detail/{id}")
	public InvoiceModel GetInvoiceById(@PathVariable("id") int id) {
		System.out.println(id);
		return ds.GetInvoiceDeatilById(id);
	}
	
	@PostMapping("/detail")
	public String AddInvoice(@RequestBody InvoiceDetail c) {
System.out.println(c.getTotal_amount());
System.out.println(c.getInvoice_date());

List<InvoiceItem>lst=c.getInvoiceitems();
for(InvoiceItem i:lst) {
	System.out.println(i.getQuantity()+" "+i.getItem().getItem_id());
}

System.out.println(c.getCustomer().getCustomer_id());

				ds.AddDetails(c);
		return "Invoice Added successfully";
	}
	
	@PutMapping("/detail")
	public String UpdateInvoice(@RequestBody InvoiceDetail c) {
		ds.UpdateDetails(c);
		return "Invoice Updated Successfully";
	}
	
	@DeleteMapping("/detail/{id}")
	public String DeleteInvoice(@PathVariable("id") int id) {
		 ds.DeleteInvoiceDetails(id);
		 return "Invoice Deleted Successfully";
	}

}
