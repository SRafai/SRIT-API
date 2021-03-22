package com.srit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class GpsRowData implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehicule;
	private Date date;
	private String latitude;
	private String longitude;
	
	public GpsRowData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GpsRowData(Date date, Fournisseur fournisseur, Client client, Vehicule vehicule, String latitude, String longitude) {
		super();
		this.fournisseur = fournisseur;
		this.client = client;
		this.vehicule = vehicule;
		this.latitude = latitude;
		this.longitude = longitude;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idGps) {
		this.id = idGps;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	

}
