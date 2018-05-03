package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
@Table(name="agents")
public class Agent implements Serializable{
	
	// déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_a")
	private int id;
	private String identifiant;
	private String mdp;
	private int tel;
	
	@JsonIgnore
	@OneToMany(mappedBy="agent", fetch = FetchType.LAZY)
	private List<Visite> visites;
	
	// déclaration des constructeurs
	public Agent() {
		super();
	}	

	public Agent(String identifiant, String mdp, int tel) {
		super();
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.tel = tel;
	}


	public Agent(int id, String identifiant, String mdp, int tel) {
		super();
		this.id = id;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.tel = tel;
	}

	// getters et setters
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}
	
	
	

}
