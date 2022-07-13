package com.repository;

import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.details.Userdetails;

@Repository

public interface Userrepository extends JpaRepository<Userdetails, Integer> {

	List<Userdetails> findAllById(int id);

}
