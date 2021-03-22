package com.srit.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
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
public class Article implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String codeArticle;
	@ManyToOne
	@JoinColumn(name = "idfour")
	private Fournisseur fournisseur;
	private String type;
	private String codeFamille;
	private String designation;
	private Double prix;
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Planning> plannings;
	@OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
	private List<Commande> commandes;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Article(String codeArticle, Fournisseur fournisseur, String type, String codeFamille, String designation,
			Double prix) {
		super();
		this.codeArticle = codeArticle;
		this.fournisseur = fournisseur;
		this.type = type;
		this.codeFamille = codeFamille;
		this.designation = designation;
		this.prix = prix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodeArticle() {
		return codeArticle;
	}

	public void setCodeArticle(String codeArticle) {
		this.codeArticle = codeArticle;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@JsonIgnore
	public List<Planning> getPlannings() {
		return plannings;
	}
	@JsonSetter
	public void setPlannings(List<Planning> plannings) {
		this.plannings = plannings;
	}
	@JsonIgnore
	public List<Commande> getCommandes() {
		return commandes;
	}

	@JsonSetter
	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}
	

}
