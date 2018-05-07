package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="comptes")
public class Compte {

	//attributs
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cpt")
	private int id;
	private int numeroCompte;
	private double solde;

	//transformation de l'association uml : RESERVATION
	@OneToMany(mappedBy="compte")
	private List<Reservation> listeReservations;
	
	//constructeurs
	
	public Compte() {
		super();
	}
	
	public Compte(int id, int numeroCompte, double solde) {
		super();
		this.id = id;
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	}
	
	public Compte(int numeroCompte, double solde) {
		super();
		this.numeroCompte = numeroCompte;
		this.solde = solde;
	}
	
	
	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroCompte() {
		return numeroCompte;
	}

	public void setNumeroCompte(int numeroCompte) {
		this.numeroCompte = numeroCompte;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}


	public List<Reservation> getListeReservations() {
		return listeReservations;
	}

	public void setListeReservations(List<Reservation> listeReservations) {
		this.listeReservations = listeReservations;
	}

	//to string
	@Override
	public String toString() {
		return "Compte [id=" + id + ", numeroCompte=" + numeroCompte + ", solde=" + solde + "]";
	}
	
}
