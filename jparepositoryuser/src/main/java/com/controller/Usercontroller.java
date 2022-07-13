package com.controller;

 
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.details.Userdetails;
import com.service.Userservice;
 
@RestController
public class Usercontroller {

	@Autowired
	Userservice userservices;
	
	
	@PostMapping("/contactdetails")
	public    String  insertContactDetails(@RequestBody Userdetails  user) {
 		 return userservices.insertContactDetails(user);
		 
	}
	
	@DeleteMapping("/contactdetails/{id}")
	public    String deleteContactDetails(@PathVariable int id) {
		    return userservices.deleteContactDetails(id);
		        
  		
	}
	@GetMapping("/contactdetails")
	public  List<Userdetails> getContactDetails(@RequestParam  int id) {
		return userservices.getContactDetails(id);
		
   }
}
