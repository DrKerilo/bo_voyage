package fr.adaming.model;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="clients")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@AttributeOverride(name="id", column=@Column(name="id_cl"))
public class Client extends Accompagnant{

	// Déclaration des attributs 
	private String tel;
	private String mail;
	private String mdp;
	
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Reservation> listeReservation;

	public Client() {
		super();
	}
	
	

	
	public Client(String civilite, String nom, String prenom, Date dn, Adresse adresse, String tel, String mail,
			String mdp) {
		super(civilite, nom, prenom, dn, adresse);
		this.tel = tel;
		this.mail = mail;
		this.mdp = mdp;
	}




	public Client(int id, String civilite, String nom, String prenom, Date dn, Adresse adresse, String tel, String mail,
			String mdp) {
		super(id, civilite, nom, prenom, dn, adresse);
		this.tel = tel;
		this.mail = mail;
		this.mdp = mdp;
	}




	// Déclaration des getters et des setters 
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public List<Reservation> getListeReservation() {
		return listeReservation;
	}

	public void setListeReservation(List<Reservation> listeReservation) {
		this.listeReservation = listeReservation;
	}




	public String getMdp() {
		return mdp;
	}




	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	
	
	
	
}
