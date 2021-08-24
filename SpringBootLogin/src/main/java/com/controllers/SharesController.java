package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.dao.SharesDAO;
import com.pojo.CustomerShares;



@RestController
public class SharesController {
	
	@Autowired
	SharesDAO dao;


	@GetMapping("/saveShare")
	//@CrossOrigin(origins = "http://localhost:4200")
	public int addShares(CustomerShares share) throws Exception {
		
//		long millis=System.currentTimeMillis();  
//		java.sql.Date date=new java.sql.Date(millis);

	
		CustomerShares savedShare=new CustomerShares(share.getUser_id(),share.getStock_symbol(),share.getStock_shortname(),share.getStock_bseprice()
				,share.getStock_nseprice(),share.getStock_profit(),share.getStock_quantity(),share.getSaved_time());
//		CustomerShares savedShare=new CustomerShares(1,"HDFC.NS","Housing ltd",325.25,328.12,5.59,3,date);
		System.out.println(savedShare);
		int result= dao.saveShare(savedShare);
		
		if(result>0)
		{
			System.out.println(result);
			System.out.println("INSERTED");
		}
		return result;
	}
	
	@GetMapping("/portfolio/{user_id}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<CustomerShares> showSavedShares(@PathVariable int user_id) throws Exception 
	{
		
		return dao.displayAllShares(user_id);
		 
	}
	
	@GetMapping("/deleteShare/{instrumentSymbol}")
	@CrossOrigin(origins = "http://localhost:4200")
	public int deletemyshare(@PathVariable String instrumentSymbol)
	{
        int result= dao.deleteShare(instrumentSymbol);
		
		if(result>0)
		{
			System.out.println(result);
			System.out.println("DELETED");
		}
		return result;
		
	}

}