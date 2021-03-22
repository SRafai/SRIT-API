package com.srit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Rappel implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "id_sender")
	private AppUser sender;
	@ManyToOne
	@JoinColumn(name = "id_receiver")
	private AppUser receiver;
	private Boolean isSeen;
	private String motif;
	private String message;
	private Date date;
	
	public Rappel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rappel(AppUser sender, AppUser receiver, Date date, Boolean isSeen, String motif, String message) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.isSeen = isSeen;
		this.motif = motif;
		this.message = message;
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

	public void setId(Long id) {
		this.id = id;
	}

	public AppUser getSender() {
		return sender;
	}

	public void setSender(AppUser sender) {
		this.sender = sender;
	}

	public AppUser getReceiver() {
		return receiver;
	}

	public void setReceiver(AppUser receiver) {
		this.receiver = receiver;
	}

	public Boolean getIsSeen() {
		return isSeen;
	}

	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
