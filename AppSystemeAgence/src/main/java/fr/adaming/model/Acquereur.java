package fr.adaming.model;

import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name="acquereurs")
@AttributeOverride(name = "id", column = @Column(name = "id_acq"))
public class Acquereur {

	
	// Transformatio nde l'association UML en JAVA
	@JsonIgnore
	@OneToMany(mappedBy = "acquereur", fetch = FetchType.LAZY)	
	private List<Contrat> listeContrats;
	
	

	// Getter et setter
	public List<Contrat> getListeContrats() {
		return listeContrats;
	}

	public void setListeContrats(List<Contrat> listeContrats) {
		this.listeContrats = listeContrats;
	}

}
