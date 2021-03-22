package com.srit.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Commande implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "idArt")
	private Article article;
	private int quantite;
	@ManyToOne
	@JoinColumn(name = "id_bc")
	private BC bc;
	
	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(Article article, int quantite, BC bc) {
		super();
		this.article = article;
		this.quantite = quantite;
		this.bc = bc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public BC getBc() {
		return bc;
	}

	public void setBc(BC bc) {
		this.bc = bc;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
}
