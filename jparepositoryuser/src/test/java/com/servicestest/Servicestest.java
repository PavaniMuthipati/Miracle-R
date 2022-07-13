package com.servicestest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.details.Userdetails;
import com.repository.Userrepository;
import com.service.Userservice;

@SpringBootTest
public class Servicestest {

	@InjectMocks
	Userservice userservice;

	@Mock
	Userrepository userrepository;

	@Test
	public void insertContactDetailsTest() {
		Mockito.when(userrepository.save(Mockito.any(Userdetails.class)));
		String str = userservice.insertContactDetails(response());
		/*
		 * Userdetails user = new Userdetails(111, "Anjali", "876543");
		 * when(userrepository.save(user)).thenReturn(user); assertEquals(user,
		 * userservice.insertContactDetails(user));
		 */
	}

	public Userdetails response() {
		Userdetails user = new Userdetails();
		user.setId(111);
		user.setName("Aruna");
		user.setPhnno("8654");
		return user;
	}

	@Test
	public void getContactDetailsTest() {
		int id = 111;
		when(userrepository.findAllById(id))
				.thenReturn(Stream.of(new Userdetails(654, "Arjun", "87654")).collect(Collectors.toList()));
		assertEquals(1, userservice.getContactDetails(id).size());
	}

	@Test
	public void deleteContactDetailsTest() {
		Userdetails user = new Userdetails(222, "Arun", "3543689");
		userservice.deleteContactDetails(user.getId());
		verify(userrepository, times(1)).deleteById(user.getId());
	}

}
