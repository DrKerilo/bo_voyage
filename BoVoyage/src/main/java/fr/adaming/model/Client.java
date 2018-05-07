package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clients")
public class Client {

	// Déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cl")
	private int id;
	private String civilite;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dn;
	@Embedded
	private Adresse adresse;

	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Reservation> listeReservation;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String civilite, String nom, String prenom, Date dn, Adresse adresse,
			List<Reservation> listeReservation) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.listeReservation = listeReservation;
	}

	public Client(int id, String civilite, String nom, String prenom, Date dn, Adresse adresse,
			List<Reservation> listeReservation) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.listeReservation = listeReservation;
	}

	// Getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
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

	public Date getDn() {
		return dn;
	}

	public void setDn(Date dn) {
		this.dn = dn;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}

	// toString
	@Override
	public String toString() {
		return "Client [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn
				+ ", adresse=" + adresse + ", listeReservation=" + listeReservation + "]";
	}

}
