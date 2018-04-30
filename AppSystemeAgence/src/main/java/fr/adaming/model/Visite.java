package fr.adaming.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="visites")
public class Visite {

	// déclaration des attributs
	private int id;
	private Date date;
	
	// associations uml en java
	@ManyToOne
	@JoinColumn(name="cl_num", referencedColumnName="numCl")
	private Client client;
	
	// ajouter l'association avec le conseillier
	
	// déclaration des constructeurs
	public Visite() {
		super();
	}

	public Visite(Date date) {
		super();
		this.date = date;
	}

	public Visite(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}

	// getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
