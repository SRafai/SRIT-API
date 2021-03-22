package com.srit.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class BC implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String image_path;
	private Date date;
	@OneToMany(mappedBy = "bc", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	@ManyToOne
	@JoinColumn(name="id_vehicule")
	private Vehicule vehicule;
	private Boolean isValid;
	
	public BC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BC(String title, String image_path, Date date, Vehicule vehicule, Boolean isValid) {
		super();
		this.title = title;
		this.image_path = image_path;
		this.date = date;
		this.vehicule = vehicule;
		this.isValid = isValid;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@JsonIgnore
	public List<Commande> getCommandes() {
		return commandes;
	}

	@JsonSetter
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
