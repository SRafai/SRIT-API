package com.srit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Fournisseur implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String codeFournisseur;
	private String rs;
	private int siren;
	private String type; //Fournisseur Produit - Pièces
	private String latitude;
	private String longitude;
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Article> articles;
	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
	private List<GpsRowData> gpsRowsData;
	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
	private List<Planning> plannings;
	
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String codeFournisseur, String rs, int siren, String type, String latitude, String longitude) {
		super();
		this.codeFournisseur = codeFournisseur;
		this.rs = rs;
		this.siren = siren;
		this.type = type;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long idFournisseur) {
		this.id = idFournisseur;
	}
	public String getCodeFournisseur() {
		return codeFournisseur;
	}
	public void setCodeFournisseur(String codeFournisseur) {
		this.codeFournisseur = codeFournisseur;
	}
	public String getRs() {
		return rs;
	}
	public void setRs(String rs) {
		this.rs = rs;
	}
	public int getSiren() {
		return siren;
	}
	public void setSiren(int siren) {
		this.siren = siren;
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

	@JsonIgnore
	public List<Article> getArticles() {
		return articles;
	}
    @JsonSetter
	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	@JsonIgnore
	public List<GpsRowData> getGpsRowsData() {
		return gpsRowsData;
	}
	@JsonSetter
	public void setGpsRowsData(List<GpsRowData> gpsRowsData) {
		this.gpsRowsData = gpsRowsData;
	}
	@JsonIgnore
	public List<Planning> getPlannings() {
		return plannings;
	}
	@JsonSetter
	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
