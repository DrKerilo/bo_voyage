package fr.adaming.model;

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
	
	@OneToMany(mappedBy="client", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
	private List<Reservation> listeReservation;

	public Client() {
		super();
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
	
	
	
	
	
}
