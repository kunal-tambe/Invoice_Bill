package invoicepackage.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import invoicepackage.model.*;
import java.util.*;
import invoicepackage.repository.*;

@Service
@Transactional
public class ItemService {

	@Autowired
	ItemRepository ir;
	
	public List<Item> GetAllItems(){
		  List<Item>lst= ir.findAll();
		   List<Item>lst1=new ArrayList<Item>();

		   for (Item c :lst) {
		 c.setInvoiceitems(null);
		 lst1.add(c);
			
		}
		   return lst1;
	}
	
	public Item GetItemById(Integer id) {
		 Item m= ir.findById(id).get();
		m.setInvoiceitems(null);	
		return m;
	}
	
	public void AddItem(Item c) {
		ir.save(c);
	}
	

	public void UpdateItem(Item c) {
		ir.save(c);
	}
	
	public void DeleteItem(Integer id) {
		ir.deleteById(id);
	}
}
