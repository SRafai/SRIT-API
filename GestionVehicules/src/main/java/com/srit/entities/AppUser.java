package com.srit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class AppUser implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@OneToMany(mappedBy = "receiver")
	private List<Rappel> rappelReceiver;
	@OneToMany(mappedBy = "sender")
	private List<Rappel> rappelSender;
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;
	
	
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AppUser(String firstName, String lastName, String email, String password, Role role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	@JsonIgnore
	public List<Rappel> getRappelReceiver() {
		return rappelReceiver;
	}

	@JsonSetter
	public void setRappelReceiver(List<Rappel> rappelReceiver) {
		this.rappelReceiver = rappelReceiver;
	}

	@JsonIgnore
	public List<Rappel> getRappelSender() {
		return rappelSender;
	}

	@JsonSetter
	public void setRappelSender(List<Rappel> rappelSender) {
		this.rappelSender = rappelSender;
	}	

}
