package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	// attributs pour l'authentification
	private String mail;
	private String mdp;
	@Column(columnDefinition="TINYINT(1)")
	private boolean active;

	// Transformation de l'association UML en Java
	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private List<Reservation> listeReservation;
	
	@OneToMany(mappedBy="client")
	private List<Role> roles;

	// Constructeurs
	public Client() {
		super();
	}

	public Client(String civilite, String nom, String prenom, Date dn, Adresse adresse, String mail, String mdp) {
		super();
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.mail = mail;
		this.mdp = mdp;
	}


	public Client(int id, String civilite, String nom, String prenom, Date dn, Adresse adresse, String mail,
			String mdp) {
		super();
		this.id = id;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.dn = dn;
		this.adresse = adresse;
		this.mail = mail;
		this.mdp = mdp;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	// toString
	@Override
	public String toString() {
		return "Client [id=" + id + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom + ", dn=" + dn
				+ ", adresse=" + adresse + ", mail=" + mail + ", mdp=" + mdp + "]";
	}
	

}
