package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;


@XmlRootElement
@Entity
@Table(name="contrats")
public class Contrat implements Serializable {
	
	// Attributs
	@Id
	@Column(name="id_co")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String Type;
	private int numero;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	private double prixAchat;
	
	// Transformation de l'association UML en JAVA
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "acq_id", referencedColumnName = "id_cl" )
	private Acquereur acquereur;
	
	// Constructeurs
	public Contrat() {
		super();
	}

	
	public Contrat(String type, int numero, Date date, double prixAchat) {
		super();
		Type = type;
		this.numero = numero;
		this.date = date;
		this.prixAchat = prixAchat;
	}



	// Getters et setters
	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public double getPrixAchat() {
		return prixAchat;
	}


	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	

	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public Acquereur getAcquereur() {
		return acquereur;
	}


	public void setAcquereur(Acquereur acquereur) {
		this.acquereur = acquereur;
	}


	@Override
	public String toString() {
		return "Contrat [numero=" + numero + ", date=" + date + ", prixAchat=" + prixAchat + "]";
	}
	
	

}
