package fr.adaming.model;

public class ClasseStandard {
	
	// déclaration des attributs
	private int code;
	private String type;
	private String modeOffre;
	private double prixMax;
	private double superficieMin;
	
	// association uml en java
	
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
