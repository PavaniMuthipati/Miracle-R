package com.details;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "contactdetails")
public class Userdetails {

	 
	public Userdetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	private int id;
	private String name;
	private String phnno;
	
	public Userdetails(int id, String name, String phnno) {
		super();
		this.id = id;
		this.name = name;
		this.phnno = phnno;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhnno() {
		return phnno;
	}
	public void setPhnno(String phnno) {
		this.phnno = phnno;
	}

}
