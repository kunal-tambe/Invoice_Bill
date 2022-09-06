package invoicepackage.services;
import invoicepackage.model.*;
import java.util.*;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import invoicepackage.repository.*;

@Service
@Transactional
public class InvoiceDetailService {

	@Autowired
	InvoiceDetailRepository dr;
	
	@Autowired
	InvoiceItemRepository ir;
	
	@Autowired
	InvoicePaymentRepository pr;
	
	public List<InvoiceModel> GetAllInvoiceDetails(){	
     List<InvoiceDetail>lst=dr.findAll();
     List<InvoiceModel>invoicelist=new ArrayList<InvoiceModel>();
     for(InvoiceDetail d :lst) {
    	 
    	 List<InvoicePayment>payments=pr.findAll();
    	 int total_amount=0,remaining_amount=0,paid_amount=0;
    	 for(InvoicePayment p :payments) {
    		 if(d.getInvoice_id()==p.getInvoicedetail().getInvoice_id()) {
    			 paid_amount+=p.getPayment_amount();
    		 }
    	 }
    	 for(InvoicePayment pd:payments) {
    		 System.out.println(pd.getPayment_amount()+" "+pd.getPayment_date()+" "+pd.getDescription()+" "+ pd.getPayment_id());
    	 }
    	 System.out.println();
    	 total_amount=(int)d.getTotal_amount();
    	 remaining_amount=total_amount-paid_amount;
    	String status="";
    	if(remaining_amount==total_amount) {
    		status="Un Paid";
    	}
    	else if(remaining_amount==0)
    	{
    		status="Paid";
    	}
    	else if(paid_amount<total_amount && paid_amount>0){
    		status="Partial Paid";
    	}
    	 InvoiceModel m=new InvoiceModel(d.getInvoice_id(),d.getCustomer().getCustomer_id(),d.getCustomer().getCustomer_name(),d.getInvoice_date(),d.getTotal_amount(),paid_amount,remaining_amount,status);
    	 invoicelist.add(m);
     }
   
     	return invoicelist;
	}


	
	
	public InvoiceModel GetInvoiceDeatilById(Integer id) {
		     InvoiceDetail d=dr.findById(id).get();	
		     
		     List<InvoicePayment>payments=pr.findAll();
	    	 int total_amount=0,remaining_amount=0,paid_amount=0;
	    	 for(InvoicePayment p :payments) {
	    		 if(d.getInvoice_id()==p.getInvoicedetail().getInvoice_id()) {
	    			 paid_amount+=p.getPayment_amount();
	    		 }
	    	 }
	    	 total_amount=(int)d.getTotal_amount();
	    	 remaining_amount=total_amount-paid_amount;
		     String status="";
		     
		    InvoiceModel m=new InvoiceModel(d.getInvoice_id(),d.getCustomer().getCustomer_id(),d.getCustomer().getCustomer_name(),d.getInvoice_date(),d.getTotal_amount(),paid_amount,remaining_amount,status);
	return m;
	}

	
	
	
	
	public void AddDetails(InvoiceDetail c) {
		List<InvoiceItem>lst=c.getInvoiceitems();	
		c.setInvoiceitems(null);
		c=dr.save(c);	
		for(InvoiceItem i:lst) {
			i.setInvoicedetail(c);
			ir.save(i);
		}		
	}
	

	public void UpdateDetails(InvoiceDetail c) {
		List<InvoiceItem>lst=c.getInvoiceitems();
		c.setInvoiceitems(null);
		c=dr.save(c);
		
		for(InvoiceItem i:lst) {
			i.setInvoicedetail(c);
			ir.save(i);
		}		
		
		
	}
	
	public void DeleteInvoiceDetails(Integer id) {
		dr.deleteById(id);
	}
	

	
}
