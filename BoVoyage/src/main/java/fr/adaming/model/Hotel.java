package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "hotels")
public class Hotel {

	// id, adresse, nom, horaires, étoile, image
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_h")
	private int id;
	@Embedded
	private Adresse adresse;
	private String nom;
	@Embedded
	private Horaire horaire;
	private int etoile;
	
	@OneToMany(fetch=FetchType.EAGER)
	private List<ImageCLass> photos;
	
	@Transient
	private List<String> images;
	

	@ManyToMany(mappedBy = "listeHotel")
	private List<Offre> listeOffreVoyage;

	// Déclaration des constructeurs
	public Hotel() {
		super();
	}

	public Hotel(Adresse adresse, String nom, Horaire horaire, int etoile) {
		super();
		this.adresse = adresse;
		this.nom = nom;
		this.horaire = horaire;
		this.etoile = etoile;

	}

	public Hotel(int id, Adresse adresse, String nom, Horaire horaire, int etoile) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.nom = nom;
		this.horaire = horaire;
		this.etoile = etoile;

	}

	// Déclaration des getters et des setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	public int getEtoile() {
		return etoile;
	}

	public void setEtoile(int etoile) {
		this.etoile = etoile;
	}



	public List<ImageCLass> getPhotos() {
		return photos;
	}

	public void setPhotos(List<ImageCLass> photos) {
		this.photos = photos;
	}



	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Offre> getListeOffreVoyage() {
		return listeOffreVoyage;
	}

	public void setListeOffreVoyage(List<Offre> listeOffreVoyage) {
		this.listeOffreVoyage = listeOffreVoyage;
	}

}
