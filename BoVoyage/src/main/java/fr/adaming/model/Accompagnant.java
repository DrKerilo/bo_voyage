package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.adaming.model.Adresse;

@Entity
@Table(name = "accompagnants")
public class Accompagnant {

	// déclaration des attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ac")
	private int id;
	private String civilite;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dn;
	@Embedded
	private Adresse adresse;

	// Transformation de l'association UML en Java
	@ManyToMany
	@JoinTable(name = "accompagnants_reservations", joinColumns = @JoinColumn(name = "ac_id", referencedColumnName = "id_ac"), inverseJoinColumns = @JoinColumn(name = "res_id", referencedColumnName = "id_res"))
	private List<Reservation> listeRes;

	// déclarations des constructeurs
	public Accompagnant() {
		super();
	}

	public Accompagnant(String civilite, String nom, String prenom, Date dn, Adresse adresse) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
	}

	public Accompagnant(int id, String civilite, String nom, String prenom, Date dn, Adresse adresse) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
	}

	// getters et setters
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

	public List<Reservation> getListeRes() {
		return listeRes;
	}

	public void setListeRes(List<Reservation> listeRes) {
		this.listeRes = listeRes;
	}

	// toString
	@Override
	public String toString() {
		return "Accompagnant [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dn="
				+ dn + ", adresse=" + adresse + "]";
	}

}
