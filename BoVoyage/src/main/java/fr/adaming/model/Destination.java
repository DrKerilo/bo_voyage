package fr.adaming.model;

import javax.persistence.Embeddable;

@Embeddable
public class Destination {

	//attributs
	private String continent;
	private String pays;
	private String ville;
	
	
	//constucteurs
	//vide
	public Destination() {
		super();
	}

	//complet
	public Destination(String continent, String pays, String ville) {
		super();
		this.continent = continent;
		this.pays = pays;
		this.ville = ville;
	}
	
	//getters et setters
	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public String getPays() {
		return pays;
	}


	public void setPays(String pays) {
		this.pays = pays;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}

	
	//toString
	@Override
	public String toString() {
		return "Destination [continent=" + continent + ", pays=" + pays + ", ville=" + ville + "]";
	}
	
}
