package fr.adaming.model;

public class Personne {
	
	// Attributs
	
	private int id;
	private String nom;
	private String prenom;
	private int telPerso;
	
	// Transformation de l'association UML en JAVA
	private Adresse adresse;

	// Constructeurs
	public Personne() {
		super();
	}

	public Personne(String nom, String prenom, int telPerso) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telPerso = telPerso;
		
	}

	public Personne(int id, String nom, String prenom, int telPerso) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.telPerso = telPerso;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getTelPerso() {
		return telPerso;
	}

	public void setTelPerso(int telPerso) {
		this.telPerso = telPerso;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telPerso=" + telPerso + "]";
	}

	
	

	

}
