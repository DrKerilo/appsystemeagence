package fr.adaming.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.adaming.model.enumerations.ImmoStatut;

@XmlRootElement
@Entity
@Table(name = "biens_immobiliers")
public class BienImmobilier implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_bien")
	private int id;
	@Enumerated(EnumType.STRING)
	private ImmoStatut statut;
	@Temporal(TemporalType.DATE)
	private Date dateSoumission;
	@Embedded
	private Adresse adresse;
	@Temporal(TemporalType.DATE)
	private Date dateDisposition;
	private double revenuCadastral;
	@Lob
	private byte[] photo;

	// Associations UML en Java
	@ManyToOne
	@JoinColumn(name = "cs_id", referencedColumnName = "id_cs")
	private ClasseStandard classeStandard;

	@ManyToOne
	@JoinColumn(name = "pr_id", referencedColumnName = "id_pr")
	private Proprietaire proprietaire;

	@OneToMany(mappedBy = "bienImmo",fetch=FetchType.LAZY)
	@JsonIgnore
	private List<Visite> listeVisites;

	// private Acquereur acquereur;

	public ClasseStandard getClasseStandard() {
		return classeStandard;
	}

	public void setClasseStandard(ClasseStandard classeStandard) {
		this.classeStandard = classeStandard;
	}

	// Constructeurs
	public BienImmobilier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BienImmobilier(ImmoStatut statut, Date dateSoumission, Adresse adresse, Date dateDisposition,
			double revenuCadastral) {
		super();
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
	}

	public BienImmobilier(int id, ImmoStatut statut, Date dateSoumission, Adresse adresse, Date dateDisposition,
			double revenuCadastral) {
		super();
		this.id = id;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ImmoStatut getStatut() {
		return statut;
	}

	public void setStatut(ImmoStatut statut) {
		this.statut = statut;
	}

	public Date getDateSoumission() {
		return dateSoumission;
	}

	public void setDateSoumission(Date dateSoumission) {
		this.dateSoumission = dateSoumission;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Date getDateDisposition() {
		return dateDisposition;
	}

	public void setDateDisposition(Date dateDisposition) {
		this.dateDisposition = dateDisposition;
	}

	public double getRevenuCadastral() {
		return revenuCadastral;
	}

	public void setRevenuCadastral(double revenuCadastral) {
		this.revenuCadastral = revenuCadastral;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Proprietaire getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Proprietaire proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Visite> getListeVisites() {
		return listeVisites;
	}

	public void setListeVisites(List<Visite> listeVisites) {
		this.listeVisites = listeVisites;
	}

	// Méthode
	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission
				+ ", dateDisposition=" + dateDisposition + ", revenuCadastral=" + revenuCadastral + "]";
	}

}
