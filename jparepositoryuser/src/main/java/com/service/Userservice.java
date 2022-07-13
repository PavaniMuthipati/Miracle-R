package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.details.Userdetails;
import com.repository.Userrepository;

 
@Service
public class Userservice {

	@Autowired
	Userrepository userrepository;
	

	public String insertContactDetails(Userdetails user) {
		userrepository.save(user);
		return "Inserted Successfully";

	}

	public String deleteContactDetails(int id) {
		userrepository.deleteById(id);
		return "Deleted Successfully";

	}

	public List<Userdetails> getContactDetails(int id) {
          return userrepository.findAllById(id);

	}

}
