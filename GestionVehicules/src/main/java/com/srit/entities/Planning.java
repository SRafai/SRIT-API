package com.srit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Planning implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(mappedBy = "planning", fetch = FetchType.LAZY)
	private BL bl;
	@ManyToOne
	@JoinColumn(name = "id_client")
	private Client client;
	@ManyToOne
	@JoinColumn(name = "id_fournisseur")
	private Fournisseur fournisseur;
	@ManyToOne
	@JoinColumn(name = "id_vehicule")
	private Vehicule vehicule;
	@ManyToOne
	@JoinColumn(name="id_produit")
	private Article article;
	private Date date;
	private Long peseeFournisseur;
	private Long peseeClient;
	private String unitePesee;
	private Boolean isValidF;
	private Boolean isValidC;
	private Date dateValidF;
	private Date dateValidC;
	
	public Planning() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Planning(Client client, Fournisseur fournisseur, Vehicule vehicule, Article article, Date date,
			Long peseeFournisseur, Long peseeClient, String unitePesee, Boolean isValidF, Boolean isValidC,
			Date dateValidF, Date dateValidC) {
		super();
		this.client = client;
		this.fournisseur = fournisseur;
		this.vehicule = vehicule;
		this.article = article;
		this.date = date;
		this.peseeFournisseur = peseeFournisseur;
		this.peseeClient = peseeClient;
		this.unitePesee = unitePesee;
		this.isValidF = isValidF;
		this.isValidC = isValidC;
		this.dateValidF = dateValidF;
		this.dateValidC = dateValidC;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BL getBl() {
		return bl;
	}

	public void setBl(BL bl) {
		this.bl = bl;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Article getProduit() {
		return article;
	}

	public void setProduit(Article article) {
		this.article = article;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPeseeFournisseur() {
		return peseeFournisseur;
	}

	public void setPeseeFournisseur(Long peseeFournisseur) {
		this.peseeFournisseur = peseeFournisseur;
	}

	public Long getPeseeClient() {
		return peseeClient;
	}

	public void setPeseeClient(Long peseeClient) {
		this.peseeClient = peseeClient;
	}

	public String getUnitePesee() {
		return unitePesee;
	}

	public void setUnitePesee(String unitePesee) {
		this.unitePesee = unitePesee;
	}

	public Boolean getIsValidF() {
		return isValidF;
	}

	public void setIsValidF(Boolean isValidF) {
		this.isValidF = isValidF;
	}

	public Boolean getIsValidC() {
		return isValidC;
	}

	public void setIsValidC(Boolean isValidC) {
		this.isValidC = isValidC;
	}

	public Date getDateValidF() {
		return dateValidF;
	}

	public void setDateValidF(Date dateValidF) {
		this.dateValidF = dateValidF;
	}

	public Date getDateValidC() {
		return dateValidC;
	}

	public void setDateValidC(Date dateValidC) {
		this.dateValidC = dateValidC;
	}
	
}
