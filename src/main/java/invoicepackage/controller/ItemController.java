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
public class ItemController {

	@Autowired
	ItemService ir;
	
	@GetMapping("/item")
	public List<Item>GetAllItems(){
		return ir.GetAllItems();
	}
	
	@GetMapping("/item/{id}")
	public Item GetItemById(@PathVariable("id") int id) {
		return ir.GetItemById(id);
	}
	
	@PostMapping("/item")
	public String AddItems(@RequestBody Item c) {
		ir.AddItem(c);
		return "Item Added successfully";
	}
	
	@PutMapping("/item")
	public String UpdateItems(@RequestBody Item c) {
		ir.UpdateItem(c);
		return "Item Updated Successfully";
	}
	
	@DeleteMapping("/item/{id}")
	public String DeleteItem(@PathVariable("id") int id) {
		 ir.DeleteItem(id);
		 return "Item Deleted Successfully";
	}

}
