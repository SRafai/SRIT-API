package com.srit.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Role {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	private List<AppUser> appUsers;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@JsonIgnore
	public List<AppUser> getAppUsers() {
		return appUsers;
	}
	@JsonSetter
	public void setAppUsers(List<AppUser> appUsers) {
		this.appUsers = appUsers;
	}
	public Long getId() {
		return id;
	}
	
	

}
