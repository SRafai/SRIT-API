package com.srit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class BL implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String image_path;
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehicule;
	private Date date;
	@OneToOne
	@JoinColumn(name="id_planning")
	private Planning planning;
	
	public BL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BL(Planning planning,  Vehicule vehicule, String image_path, Date date) {
		super();
		this.image_path = image_path;
		this.vehicule = vehicule;
		this.date = date;
		this.planning = planning;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImage_path() {
		return image_path;
	}

	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@JsonIgnore
	public Planning getPlanning() {
		return planning;
	}

	@JsonSetter
	public void setPlanning(Planning planning) {
		this.planning = planning;
	}
	
	
	

}
