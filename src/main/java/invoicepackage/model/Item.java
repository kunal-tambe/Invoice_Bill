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
@Table(name = "tblitems")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int item_id;
	private String item_name;
	private float rate;
	private float tax;
	private int stoke_quantity;
	
	@OneToMany(mappedBy = "item",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JsonIgnoreProperties("item")

	private List<InvoiceItem>invoiceitems;

	
	public Item(int item_id, String item_name, float rate, float tax, int stoke_quantity) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.rate = rate;
		this.tax = tax;
		this.stoke_quantity = stoke_quantity;
	}


	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getTax() {
		return tax;
	}

	public void setTax(float tax) {
		this.tax = tax;
	}

	public int getStoke_quantity() {
		return stoke_quantity;
	}

	public void setStoke_quantity(int stoke_quantity) {
		this.stoke_quantity = stoke_quantity;
	}

	public List<InvoiceItem> getInvoiceitems() {
		return invoiceitems;
	}

	public void setInvoiceitems(List<InvoiceItem> invoiceitems) {
		this.invoiceitems = invoiceitems;
	}

	public Item(int item_id, String item_name, float rate, float tax, int stoke_quantity,
			List<InvoiceItem> invoiceitems) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.rate = rate;
		this.tax = tax;
		this.stoke_quantity = stoke_quantity;
		this.invoiceitems = invoiceitems;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
