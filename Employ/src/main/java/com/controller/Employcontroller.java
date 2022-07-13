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

import com.details.Employdetails;
import com.service.Employservice;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class Employcontroller {

	@Autowired
	Employservice employservice;

	@PostMapping("/details")
	public Map<String,Object> insert(@RequestBody Employdetails emp) {
		employservice.insert(emp);
		 log.info("inserted");
		return null;
	}

	@PutMapping("/details")
	public    Map<String,Object>  update(@RequestParam  String mail,@RequestParam int id) {
		 log.info ("updated");
		return employservice.update(mail,id);
		  
	}

	@DeleteMapping("/details")
	public Map<String, Object> delete(@RequestParam int id) {
	return employservice.delete(id);
	}
	
	@GetMapping("/details/{id}")
	public List<Map<String, Object>> select(@PathVariable int id) {
		return employservice.select(id);
	}

	@PostMapping("/create")
	public String get() {
		return employservice.create();
	}
}
