package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import fr.adaming.model.enumerations.ModeOffre;

@XmlRootElement
@Entity
@Table(name="classes_standards")
public class ClasseStandard implements Serializable{
	
	// déclaration des attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cs")
	private int code;
	private String type;
//	@Enumerated(EnumType.STRING)
	private String modeOffre;
	private double prixMax;
	private double superficieMin;
	
	// association uml en java
	@JsonIgnore
	@OneToMany(mappedBy="classeStandard", fetch=FetchType.EAGER)
	private List<BienImmobilier> listeBiens;
	
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

	public List<BienImmobilier> getListeBiens() {
		return listeBiens;
	}

	public void setListeBiens(List<BienImmobilier> listeBiens) {
		this.listeBiens = listeBiens;
	}
	
	
	

}
