package fr.adaming.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "clients")
@AttributeOverride(name = "id", column = @Column(name = "id_cl"))
public class Client extends Personne {

	// Transformation des associations UML en JAVA
	@OneToMany
	@JoinTable(name = "recherches_clients", joinColumns = @JoinColumn(name = "cl_id"), inverseJoinColumns = @JoinColumn(name = "cs_id"))
	private List<ClasseStandard> listeClasseStd;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String nom, String prenom, int telPerso, Adresse adresse) {
		super(nom, prenom, telPerso, adresse);
	}

	public Client(int id, String nom, String prenom, int telPerso, Adresse adresse) {
		super(id, nom, prenom, telPerso, adresse);
	}

	// Getters et setters
	public List<ClasseStandard> getListeClasseStd() {
		return listeClasseStd;
	}

	public void setListeClasseStd(List<ClasseStandard> listeClasseStd) {
		this.listeClasseStd = listeClasseStd;
	}

}
