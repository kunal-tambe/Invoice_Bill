package invoicepackage.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.*;
@Entity
@Table(name = "tblinvoice_items")
public class InvoiceItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoice_item_id;

	private int quantity;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "invoice_id", nullable =false )
	private InvoiceDetail invoicedetail;
	
	
	@ManyToOne()
	@JoinColumn(name = "item_id", nullable =false )
	private Item item;


	public int getInvoice_item_id() {
		return invoice_item_id;
	}


	public void setInvoice_item_id(int invoice_item_id) {
		this.invoice_item_id = invoice_item_id;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public InvoiceDetail getInvoicedetail() {
		return invoicedetail;
	}


	public void setInvoicedetail(InvoiceDetail invoicedetail) {
		this.invoicedetail = invoicedetail;
	}


	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	public InvoiceItem(int invoice_item_id, int quantity, InvoiceDetail invoicedetail, Item item) {
		super();
		this.invoice_item_id = invoice_item_id;
		this.quantity = quantity;
		this.invoicedetail = invoicedetail;
		this.item = item;
	}


	public InvoiceItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
