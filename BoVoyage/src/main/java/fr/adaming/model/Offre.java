package fr.adaming.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "offres")
public class Offre implements Serializable {

	@Id
	@Column(name = "id_off")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String formule;
	@Embedded
	private Destination destination;
	private String hebergement;
	private String reference;
	@Temporal(TemporalType.DATE)
	private Date dateDep;
	@Temporal(TemporalType.DATE)
	private Date dateRet;
	private long nbPlacesDispo;
	private String statut;
	private double prixPublic;
	private double prixBoV;
	@Lob
	private byte[] photoOff;
	@Transient
	private String imageOff;

	// Transfo assos avec voiture
	@OneToOne(mappedBy = "offreVoyage")
	private Voiture voiture;

	// Transfo assos avec reservation
	@OneToMany(mappedBy = "offre")
	private List<Reservation> listeRes;

	// Transfo assos avec vol
	@ManyToMany
	@JoinTable(name = "offre_vol", joinColumns = @JoinColumn(name = "off_id", referencedColumnName = "id_off"), inverseJoinColumns = @JoinColumn(name = "v_id", referencedColumnName = "id_v"))
	private List<Vol> listeVol;

	// Transfo assos avec hotel
	@ManyToMany
	@JoinTable(name = "offre_hotel", joinColumns = @JoinColumn(name = "off_id", referencedColumnName = "id_off"), inverseJoinColumns = @JoinColumn(name = "h_id", referencedColumnName = "id_h"))
	private List<Hotel> listeHotel;

	// Constructeurs
	public Offre() {
		super();
	}

	public Offre(String formule, Destination destination, String hebergement, String reference, Date dateDep,
			Date dateRet, long nbPlacesDispo, String statut, double prixPublic, double prixBoV, byte[] photoOff,
			String imageOff) {
		super();
		this.formule = formule;
		this.destination = destination;
		this.hebergement = hebergement;
		this.reference = reference;
		this.dateDep = dateDep;
		this.dateRet = dateRet;
		this.nbPlacesDispo = nbPlacesDispo;
		this.statut = statut;
		this.prixPublic = prixPublic;
		this.prixBoV = prixBoV;
		this.photoOff = photoOff;
		this.imageOff = imageOff;
	}

	public Offre(int id, String formule, Destination destination, String hebergement, String reference, Date dateDep,
			Date dateRet, long nbPlacesDispo, String statut, double prixPublic, double prixBoV, byte[] photoOff,
			String imageOff) {
		super();
		this.id = id;
		this.formule = formule;
		this.destination = destination;
		this.hebergement = hebergement;
		this.reference = reference;
		this.dateDep = dateDep;
		this.dateRet = dateRet;
		this.nbPlacesDispo = nbPlacesDispo;
		this.statut = statut;
		this.prixPublic = prixPublic;
		this.prixBoV = prixBoV;
		this.photoOff = photoOff;
		this.imageOff = imageOff;
	}

	// Getter et setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public String getHebergement() {
		return hebergement;
	}

	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Date getDateDep() {
		return dateDep;
	}

	public void setDateDep(Date dateDep) {
		this.dateDep = dateDep;
	}

	public Date getDateRet() {
		return dateRet;
	}

	public void setDateRet(Date dateRet) {
		this.dateRet = dateRet;
	}

	public long getNbPlacesDispo() {
		return nbPlacesDispo;
	}

	public void setNbPlacesDispo(long nbPlacesDispo) {
		this.nbPlacesDispo = nbPlacesDispo;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public double getPrixPublic() {
		return prixPublic;
	}

	public void setPrixPublic(double prixPublic) {
		this.prixPublic = prixPublic;
	}

	public double getPrixBoV() {
		return prixBoV;
	}

	public void setPrixBoV(double prixBoV) {
		this.prixBoV = prixBoV;
	}

	public byte[] getPhotoOff() {
		return photoOff;
	}

	public void setPhotoOff(byte[] photoOff) {
		this.photoOff = photoOff;
	}

	public String getImageOff() {
		return imageOff;
	}

	public void setImageOff(String imageOff) {
		this.imageOff = imageOff;
	}

	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public List<Reservation> getListeRes() {
		return listeRes;
	}

	public void setListeRes(List<Reservation> listeRes) {
		this.listeRes = listeRes;
	}

	public List<Vol> getListeVol() {
		return listeVol;
	}

	public void setListeVol(List<Vol> listeVol) {
		this.listeVol = listeVol;
	}

	public List<Hotel> getListeHotel() {
		return listeHotel;
	}

	public void setListeHotel(List<Hotel> listeHotel) {
		this.listeHotel = listeHotel;
	}

	// toString
	@Override
	public String toString() {
		return "Offre [id=" + id + ", formule=" + formule + ", hebergement=" + hebergement + ", reference=" + reference
				+ ", dateDep=" + dateDep + ", dateRet=" + dateRet + ", nbPlacesDispo=" + nbPlacesDispo + ", statut="
				+ statut + ", prixPublic=" + prixPublic + ", prixBoV=" + prixBoV + ", photoOff="
				+ Arrays.toString(photoOff) + ", imageOff=" + imageOff + "]";
	}

}
