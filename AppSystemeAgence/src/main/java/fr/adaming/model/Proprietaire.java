package fr.adaming.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name = "proprietaires")
@AttributeOverride(name = "id", column = @Column(name = "id_pr"))
public class Proprietaire extends Personne {

	// Attributs
	private int telPro;

	// Transformation de l'association UML en Java
	@JsonIgnore
	@Fetch(FetchMode.SELECT)
	@OneToMany(mappedBy = "proprietaire", fetch = FetchType.EAGER, cascade=CascadeType.DETACH)
	private List<BienImmobilier> listeBiens;

	// Constructeurs
	public Proprietaire() {
		super();
	}

	public Proprietaire(String nom, String prenom, int telPerso, Adresse adresse, int telPro) {
		super(nom, prenom, telPerso, adresse);
		this.telPro = telPro;
	}

	public Proprietaire(int id, String nom, String prenom, int telPerso, Adresse adresse, int telPro) {
		super(id, nom, prenom, telPerso, adresse);
		this.telPro = telPro;
	}

	// Getters et setters
	public int getTelPro() {
		return telPro;
	}

	public void setTelPro(int telPro) {
		this.telPro = telPro;
	}

	public List<BienImmobilier> getListeBiens() {
		return listeBiens;
	}

	public void setListeBiens(List<BienImmobilier> listeBiens) {
		this.listeBiens = listeBiens;
	}

	// toString
	@Override
	public String toString() {
		return "Proprietaire [telPro=" + telPro + ", listeBiens=" + listeBiens + "]";
	}
}
