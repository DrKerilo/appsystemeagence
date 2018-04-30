package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classesStandards")
public class ClasseStandard implements Serializable{
	
	// déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int code;
	private String type;
	private String modeOffre;
	private double prixMax;
	private double superficieMin;
	
	// association uml en java
	@OneToMany(mappedBy="classeStandard")
	private BienImmobilier bienImmo;
	
	// déclaration des constructeurs
	public ClasseStandard() {
		super();
	}

	public ClasseStandard(String type, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.type = type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}

	public ClasseStandard(int code, String type, String modeOffre, double prixMax, double superficieMin) {
		super();
		this.code = code;
		this.type = type;
		this.modeOffre = modeOffre;
		this.prixMax = prixMax;
		this.superficieMin = superficieMin;
	}

	// getters et setters
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModeOffre() {
		return modeOffre;
	}

	public void setModeOffre(String modeOffre) {
		this.modeOffre = modeOffre;
	}

	public double getPrixMax() {
		return prixMax;
	}

	public void setPrixMax(double prixMax) {
		this.prixMax = prixMax;
	}

	public double getSuperficieMin() {
		return superficieMin;
	}

	public void setSuperficieMin(double superficieMin) {
		this.superficieMin = superficieMin;
	}
	
	
	

}
