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
public class Client implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String codeClient;
	private String rs;
	private int siren;
	private String latitude;
	private String longitude;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<GpsRowData> gpsRowsData;
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private List<Planning> plannings;
	
	@JsonIgnore
	public List<GpsRowData> getGpsRowsData() {
		return gpsRowsData;
	}
	@JsonSetter
	public void setGpsRowsData(List<GpsRowData> gpsRowsData) {
		this.gpsRowsData = gpsRowsData;
	}
	public String getCodeClient() {
		return codeClient;
	}
	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
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
	public Long getId() {
		return id;
	}
	public void setId(Long idClient) {
		this.id = idClient;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String codeClient, String rs, int siren, String latitude, String longitude) {
		super();
		this.codeClient = codeClient;
		this.rs = rs;
		this.siren = siren;
		this.latitude = latitude;
		this.longitude = longitude;
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
