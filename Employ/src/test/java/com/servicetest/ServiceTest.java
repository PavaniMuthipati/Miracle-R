package com.servicetest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.xmlunit.diff.Comparison.Detail;

import com.details.Employdetails;
import com.details.Userdetails;
import com.service.Employservice;

public class ServiceTest {

	@InjectMocks
	Employservice employservice;

	@Mock
	JdbcTemplate jdbcTemplate;

	@Test
	public void insert() {
		Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(),
				Mockito.anyString(), Mockito.anyString())).thenReturn(1);
		Map<String, Object> users = employservice.insert(userresponse());
	}

	@Test
	public void insert1() {
		Mockito.when(jdbcTemplate.update(Mockito.anyString(), Mockito.anyInt(), Mockito.anyString(),
				Mockito.anyString(), Mockito.anyString())).thenReturn(0);
		Map<String, Object> users = employservice.insert(userresponse());
		 

	}

	public Employdetails userresponse() {
		Employdetails users = new Employdetails();
		users.setId(111);
		users.setName("Anu");
		users.setPhnno("8765437");
		return users;
	}

	@Test
	public void update() {
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		  Map<String,Object> mapRes = employservice.update("satish", 1);
		   
	}

	 @Test
	 public void delete() {
		Mockito.when(jdbcTemplate.update(Mockito.anyString(),Mockito.anyInt())).thenReturn(1);
		Map<String, Object> mapRes = employservice.delete(1);
		 
	}
	 

	 @Test   
	 public  void selectbyId() {
		Mockito.when(jdbcTemplate.queryForList(Mockito.anyString(),Mockito.anyInt())).thenReturn(response2());
		List<Map<String, Object>> response = employservice.select(1);
		 
		 
	}


	public List<Map<String, Object>> response2() {
		Map<String,Object> mapResponse= new HashMap<>();
		List<Map<String, Object>>  user = new  ArrayList<>();
		mapResponse.put("id", 1);
		mapResponse.put("name", "pavani");
		mapResponse.put("mail", "p@gmail.com");
		mapResponse.put("phone", "7780716842");
		user.add(mapResponse);
		return user;
	}

	public Employdetails response1() {
		Employdetails user = new Employdetails();
		user.setId(111);
		user.setName("Durga");
		user.setMail("durga345@gmail.com");
		user.setPhnno("876432");
		return user;
	}
}
