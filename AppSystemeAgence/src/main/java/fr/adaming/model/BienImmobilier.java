package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
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

import fr.adaming.model.enumerations.Bail;
import fr.adaming.model.enumerations.Etat;
import fr.adaming.model.enumerations.Garniture;
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
	// Cas de location
	private double cautionLocative;
	private double loyerMensuel;
	private double montantMensuelCharges;
	@Enumerated(EnumType.STRING)
	private Bail typeBail;
	@Enumerated(EnumType.STRING)
	private Garniture garniture;
	
	// Cas de acheter
	private double prixAchat;
	@Enumerated(EnumType.STRING)
	private Etat etat;

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
			double revenuCadastral, byte[] photo, double cautionLocative, double loyerMensuel,
			double montantMensuelCharges, Bail typeBail, Garniture garniture, double prixAchat, Etat etat,
			ClasseStandard classeStandard, Proprietaire proprietaire, List<Visite> listeVisites) {
		super();
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
		this.photo = photo;
		this.cautionLocative = cautionLocative;
		this.loyerMensuel = loyerMensuel;
		this.montantMensuelCharges = montantMensuelCharges;
		this.typeBail = typeBail;
		this.garniture = garniture;
		this.prixAchat = prixAchat;
		this.etat = etat;
		this.classeStandard = classeStandard;
		this.proprietaire = proprietaire;
		this.listeVisites = listeVisites;
	}
	
	public BienImmobilier(int id, ImmoStatut statut, Date dateSoumission, Adresse adresse, Date dateDisposition,
			double revenuCadastral, byte[] photo, double cautionLocative, double loyerMensuel,
			double montantMensuelCharges, Bail typeBail, Garniture garniture, double prixAchat, Etat etat,
			ClasseStandard classeStandard, Proprietaire proprietaire, List<Visite> listeVisites) {
		super();
		this.id = id;
		this.statut = statut;
		this.dateSoumission = dateSoumission;
		this.adresse = adresse;
		this.dateDisposition = dateDisposition;
		this.revenuCadastral = revenuCadastral;
		this.photo = photo;
		this.cautionLocative = cautionLocative;
		this.loyerMensuel = loyerMensuel;
		this.montantMensuelCharges = montantMensuelCharges;
		this.typeBail = typeBail;
		this.garniture = garniture;
		this.prixAchat = prixAchat;
		this.etat = etat;
		this.classeStandard = classeStandard;
		this.proprietaire = proprietaire;
		this.listeVisites = listeVisites;
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
	
	public double getCautionLocative() {
		return cautionLocative;
	}

	public void setCautionLocative(double cautionLocative) {
		this.cautionLocative = cautionLocative;
	}

	public double getLoyerMensuel() {
		return loyerMensuel;
	}

	public void setLoyerMensuel(double loyerMensuel) {
		this.loyerMensuel = loyerMensuel;
	}

	public double getMontantMensuelCharges() {
		return montantMensuelCharges;
	}

	public void setMontantMensuelCharges(double montantMensuelCharges) {
		this.montantMensuelCharges = montantMensuelCharges;
	}

	public Bail getTypeBail() {
		return typeBail;
	}

	public void setTypeBail(Bail typeBail) {
		this.typeBail = typeBail;
	}

	public Garniture getGarniture() {
		return garniture;
	}

	public void setGarniture(Garniture garniture) {
		this.garniture = garniture;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	// Méthode
	@Override
	public String toString() {
		return "BienImmobilier [id=" + id + ", statut=" + statut + ", dateSoumission=" + dateSoumission + ", adresse="
				+ adresse + ", dateDisposition=" + dateDisposition + ", revenuCadastral=" + revenuCadastral + ", photo="
				+ Arrays.toString(photo) + ", cautionLocative=" + cautionLocative + ", loyerMensuel=" + loyerMensuel
				+ ", montantMensuelCharges=" + montantMensuelCharges + ", typeBail=" + typeBail + ", garniture="
				+ garniture + ", prixAchat=" + prixAchat + ", etat=" + etat + "]";
	}

	


	


}
