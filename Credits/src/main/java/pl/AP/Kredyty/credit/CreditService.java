package pl.AP.Kredyty.credit;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.AP.*;
import pl.AP.Kredyty.Customer;
import pl.AP.Kredyty.CustomerService;
import pl.AP.Kredyty.Product;
import pl.AP.Kredyty.ProductService;
@Service
public class CreditService {

	@Autowired
	private ProductService b;
	@Autowired
	private CustomerService cus;
	@Autowired
	private CreditRepository crep ;
	@Autowired
	public CreditService(CreditRepository crep,CustomerService cus,ProductService b) {
		this.crep=crep;
	}
	

	
	
	
	
	@Transactional
	public List<Inform> getCredit() {
		
		List<Inform> list=new ArrayList<Inform>();
		List<Credit> crlist=crep.findAll();
		List<Product> plist=b.getProduct();
		List<Customer> clist=cus.getCustomer();
		for(int i=0;i<crlist.size();i++)
		list.add(new Inform(crlist.get(i).getName(),plist.get(i).getValue(),clist.get(i).getFirstname(),clist.get(i).getSurname(),clist.get(i).getPesel(),plist.get(i).getProductName()));
		return list;
	}
	@Transactional
	public int createCredit(Inform c) {
		
		
		
		int a=crep.save(new Credit(c.getName())).getId();
		b.createProduct(new Product(a,c.getProductname(),c.getValue()));
		cus.createCustomer(new Customer(a,c.getFirstname(),c.getSurname(),c.getPesel()));
		
		return a;
	}
	
	
}
