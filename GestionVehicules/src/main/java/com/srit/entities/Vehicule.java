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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Vehicule implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String immatriculation;
	private String nomChauffeur;
	@OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
	private List<GpsRowData> gpsRowsData;
	@OneToMany(mappedBy = "vehicule",fetch=FetchType.LAZY)
	private List<BL> bls;
	@OneToMany(mappedBy = "vehicule",fetch=FetchType.LAZY)
	private List<BC> bcs;
	@OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
	private List<Planning> plannings;
	
	public Vehicule() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicule(String immatriculation, String nomChauffeur) {
		super();
		this.immatriculation = immatriculation;
		this.nomChauffeur = nomChauffeur;
	}

	@JsonIgnore
	public List<BC> getBcs() {
		return bcs;
	}
	@JsonSetter
	public void setBcs(List<BC> bcs) {
		this.bcs = bcs;
	}

	public Long getId() {
		return id;
	}
	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getNomChauffeur() {
		return nomChauffeur;
	}

	public void setNomChauffeur(String nomChauffeur) {
		this.nomChauffeur = nomChauffeur;
	}

	@JsonIgnore
	public List<GpsRowData> getGpsRowsData() {
		return gpsRowsData;
	}

	@JsonSetter
	public void setGpsRowsData(List<GpsRowData> gpsRowsData) {
		this.gpsRowsData = gpsRowsData;
	}

	public Long getIdVeh() {
		return id;
	}

	public void setId(Long idVeh) {
		this.id = idVeh;
	}

	@JsonIgnore
	public List<BL> getBls() {
		return bls;
	}

	@JsonSetter
	public void setBls(List<BL> bls) {
		this.bls = bls;
	}

	@JsonIgnore
	public List<Planning> getPlannings() {
		return plannings;
	}
	@JsonSetter
	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	
	
	
	
	

}
