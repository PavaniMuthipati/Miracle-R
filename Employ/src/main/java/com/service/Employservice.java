package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.Aspect.EmployAspect;
import com.details.Employdetails;
import com.details.Userdetails;
 
@Service
public class Employservice {

	@Autowired
	EmployAspect employAspect;

	@Autowired
	JdbcTemplate jdbctemplate;
	
	
	//insert...

	public Map<String, Object> insert(Employdetails emp) {
		Map<String,Object> mapRes= new HashMap<>();
		int id = emp.getId();
		String name = emp.getName();
		String mail = emp.getMail();
		String phnno = emp.getPhnno();
		String s = ("insert into details values(?,?,?,?)");
		int i =jdbctemplate.update(s, id, name, mail, phnno);
		if(i>0) {
			mapRes.put("message","inserted");
		}
		else {
			mapRes.put("message","failed");
		}
		return mapRes;
	}

	//update.....
	public   Map<String,Object> update(String mail, int id) {
		Map<String,Object> mapRes= new HashMap<>();
		String s = ("update details set mail=? where id=?");
		int i= jdbctemplate.update(s, mail, id);
		if(i>0) {
			mapRes.put("message", "updated");
		}
		else {
			mapRes.put("message", "failed");
		}
		return mapRes;
		 
	}
	//delete....
	public  Map<String,Object> delete(int id) {
		 Map<String,Object> mapRes= new HashMap<>();
		String s = ("delete from details where id=?");
		int i= jdbctemplate.update(s, id);
		if(i>0) {
			mapRes.put("message", "deleted");
		}
		else {
			mapRes.put("message", "failed");
		}
		return mapRes;
	}
	
	//select by id....

	public List<Map<String, Object>> select(int id) {
		return jdbctemplate.queryForList("select * from details where id=?",id);
	}
	
	//creating.....
	public String create() {
		String s = ("create table employ2(id int,name varchar(15))");
		jdbctemplate.execute(s);
		return "Created";
	}

	 

	 

	 

	 
}
