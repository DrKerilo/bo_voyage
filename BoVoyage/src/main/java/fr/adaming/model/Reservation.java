package fr.adaming.model;

import java.io.Serializable;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable{

	@Id
	@Column(name = "id_res")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private long numDossier;
	private String etat;
	private String assurance;
	private long nbPlaces;
	private double prixRes;

	// Transfo assos avec offre
	@ManyToOne
	@JoinColumn(name = "off_id", referencedColumnName = "id_off")
	private Offre offre;

	// Transfo assos avec client
	@ManyToOne
	@JoinColumn(name = "cl_id", referencedColumnName = "id_cl")
	private Client client;

	// Transfo assos avec compte
	@ManyToOne
	@JoinColumn(name = "cpt_id", referencedColumnName = "id_cpt")
	private Compte compte;

	// Constructeurs
	public Reservation() {
		super();
	}

	public Reservation(long numDossier, String etat, String assurance, long nbPlaces, double prixRes) {
		super();
		this.numDossier = numDossier;
		this.etat = etat;
		this.assurance = assurance;
		this.nbPlaces = nbPlaces;
		this.prixRes = prixRes;
	}

	public Reservation(int id, long numDossier, String etat, String assurance, long nbPlaces, double prixRes) {
		super();
		this.id = id;
		this.numDossier = numDossier;
		this.etat = etat;
		this.assurance = assurance;
		this.nbPlaces = nbPlaces;
		this.prixRes = prixRes;
	}

	// Getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(long numDossier) {
		this.numDossier = numDossier;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getAssurance() {
		return assurance;
	}

	public void setAssurance(String assurance) {
		this.assurance = assurance;
	}

	public long getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(long nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public double getPrixRes() {
		return prixRes;
	}

	public void setPrixRes(double prixRes) {
		this.prixRes = prixRes;
	}

	public Offre getOffre() {
		return offre;
	}

	public void setOffre(Offre offre) {
		this.offre = offre;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	// toString
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", numDossier=" + numDossier + ", etat=" + etat + ", assurance=" + assurance
				+ ", nbPlaces=" + nbPlaces + ", prixRes=" + prixRes + "]";
	}

}
