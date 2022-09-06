package invoicepackage.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import invoicepackage.services.InvoicePaymentService;

@Entity
@Table(name = "tblinvoice_details")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_id;
	private String invoice_date;
	private float total_amount;
//	private int paid_amount;
//	private int remaining_amount;
//	private String status;
	
	

//	public InvoiceDetail(int invoice_id, String invoice_date, float total_amount, int paid_amount, int remaining_amount,
//			String status, Customer customer, List<InvoiceItem> invoiceitems, List<InvoicePayment> invoicepayments) {
//		super();
//		this.invoice_id = invoice_id;
//		this.invoice_date = invoice_date;
//		this.total_amount = total_amount;
//		this.paid_amount = paid_amount;
//		this.remaining_amount = remaining_amount;
//		this.status = status;
//		this.customer = customer;
//		this.invoiceitems = invoiceitems;
//		this.invoicepayments = invoicepayments;
//	}

//	public int getPaid_amount() {
//		return paid_amount;
//	}
//
//	public void setPaid_amount(int paid_amount) {
//		this.paid_amount = paid_amount;
//	}
//
//	public int getRemaining_amount() {
//		return remaining_amount;
//	}
//
//	public void setRemaining_amount(int remaining_amount) {
//		this.remaining_amount = remaining_amount;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}

	@ManyToOne()
	@JoinColumn(name = "customer_id", nullable =false )
	private Customer customer;	

	@OneToMany(mappedBy = "invoicedetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoicedetail")
	private List<InvoiceItem>invoiceitems;
	
	@OneToMany(mappedBy = "invoicedetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("invoicedetail")
	private List<InvoicePayment>invoicepayments;
	

	
	public List<InvoicePayment> getInvoicepayments() {
		return invoicepayments;
	}

	public void setInvoicepayments(List<InvoicePayment> invoicepayments) {
		this.invoicepayments = invoicepayments;
	}



	public InvoiceDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public InvoiceDetail(int invoice_id, String invoice_date, float total_amount, Customer customer,
			List<InvoiceItem> invoiceitems) {
		super();
		this.invoice_id = invoice_id;
		this.invoice_date = invoice_date;
		this.total_amount = total_amount;
		this.customer = customer;
		this.invoiceitems = invoiceitems;
	}



	public List<InvoiceItem> getInvoiceitems() {
		return invoiceitems;
	}



	public void setInvoiceitems(List<InvoiceItem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}



	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getInvoice_date() {
		return invoice_date;
	}

	public void setInvoice_date(String invoice_date) {
		this.invoice_date = invoice_date;
	}

	public float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(float total_amount) {
		this.total_amount = total_amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	


	
	
}
