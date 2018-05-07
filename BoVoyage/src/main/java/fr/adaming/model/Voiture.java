package fr.adaming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="voitures")
public class Voiture {
	
	// Déclaration des attributs 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vo")
	private int id;
	private String loueur;
	private String reference;
	private String categorie;
	private long nbplaces;
	@Lob
	private byte[] photo;
	@Transient
	private String image;
	
	
	@OneToOne
	@JoinColumn(name="off_id", referencedColumnName="id_off")
	private Offre offreVoyage;


	// Déclaration des constructeurs 
	public Voiture() {
		super();
	}


	public Voiture(String loueur, String reference, String categorie, long nbplaces, byte[] photo, String image,
			Offre offreVoyage) {
		super();
		this.loueur = loueur;
		this.reference = reference;
		this.categorie = categorie;
		this.nbplaces = nbplaces;
		this.photo = photo;
		this.image = image;
		this.offreVoyage = offreVoyage;
	}


	public Voiture(int id, String loueur, String reference, String categorie, long nbplaces, byte[] photo, String image,
			Offre offreVoyage) {
		super();
		this.id = id;
		this.loueur = loueur;
		this.reference = reference;
		this.categorie = categorie;
		this.nbplaces = nbplaces;
		this.photo = photo;
		this.image = image;
		this.offreVoyage = offreVoyage;
	}


	// Déclaration des getters et des setters 
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLoueur() {
		return loueur;
	}


	public void setLoueur(String loueur) {
		this.loueur = loueur;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


	public long getNbplaces() {
		return nbplaces;
	}


	public void setNbplaces(long nbplaces) {
		this.nbplaces = nbplaces;
	}


	public byte[] getPhoto() {
		return photo;
	}


	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public Offre getOffre() {
		return offreVoyage;
	}


	public void setOffre(Offre offreVoyage) {
		this.offreVoyage = offreVoyage;
	}
	
	
	
	
	
}
