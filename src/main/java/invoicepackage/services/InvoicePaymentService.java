package invoicepackage.services;

import javax.transaction.Transactional;
import invoicepackage.model.*;
import java.util.*;
import invoicepackage.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class InvoicePaymentService {

	@Autowired
	InvoicePaymentRepository pr;
	
	@Autowired
	InvoiceDetailRepository dr;
	
	public List<InvoicePayment> GetAllPayments(){
	    return pr.findAll();
	}
	
	public InvoicePayment GetPaymentById(Integer id) {
		return pr.findById(id).get();

	}
	
	public void AddPayment(InvoicePayment c) {
		pr.save(c);
	}
	

	public void UpdatePayment(InvoicePayment c) {
		pr.save(c);
	}
	
	public void DeletePayment(Integer id) {
		pr.deleteById(id);
	}
	
}
