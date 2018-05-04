package fr.adaming.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "clients")
@AttributeOverride(name = "id", column = @Column(name = "id_cl"))
public class Client extends Personne {

	// Attribut
	private String mail;
	
	// Transformation des associations UML en JAVA
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recherches_clients", joinColumns = @JoinColumn(name = "cl_id"), inverseJoinColumns = @JoinColumn(name = "cs_id"))
	private List<ClasseStandard> listeClasseStd;

	@JsonIgnore
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade=CascadeType.DETACH)
	private List<Visite> visites;

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String prenom, int telPerso, Adresse adresse, String mail) {
		super(nom, prenom, telPerso, adresse);
		this.mail = mail;
	}

	
	public Client(int id, String nom, String prenom, int telPerso, Adresse adresse, String mail) {
		super(id, nom, prenom, telPerso, adresse);
		this.mail = mail;
	}

	// Getters et setters
	public List<ClasseStandard> getListeClasseStd() {
		return listeClasseStd;
	}

	public void setListeClasseStd(List<ClasseStandard> listeClasseStd) {
		this.listeClasseStd = listeClasseStd;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	

}
