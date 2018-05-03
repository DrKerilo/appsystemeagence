package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "visites")
public class Visite implements Serializable {

	// déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date date;
	private int heure;

	// associations uml en java
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "a_id", referencedColumnName = "id_a")
	private Agent agent;

	@ManyToOne
	@JoinColumn(name = "bien_id", referencedColumnName = "id_bien")
	private BienImmobilier bienImmo;

	// déclaration des constructeurs
	public Visite() {
		super();
	}

	public Visite(Date date, int heure) {
		super();
		this.date = date;
		this.heure = heure;
	}

	public Visite(int id, Date date, int heure) {
		super();
		this.id = id;
		this.date = date;
		this.heure = heure;
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

	public int getHeure() {
		return heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public BienImmobilier getBienImmo() {
		return bienImmo;
	}

	public void setBienImmo(BienImmobilier bienImmo) {
		this.bienImmo = bienImmo;
	}

	// toString
	@Override
	public String toString() {
		return "Visite [id=" + id + ", date=" + date + ", heure=" + heure + ", client=" + client + ", agent=" + agent
				+ ", bienImmo=" + bienImmo + "]";
	}

}
