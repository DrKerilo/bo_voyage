package fr.adaming.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="vols")
public class Vol {
	
	//attributs
	@Id
	@Column(name="id_v")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String modele;
	private String aeroportDep;
	private String aeroportArr;
	@Embedded
	private Horaire horaire;
	
	//transformation UML 
	@ManyToMany(mappedBy="listeVol")
	private List<Offre> listeOffre;
	
	//constructeurs
	
	public Vol() {
		super();
	}
	
	public Vol(String modele, String aeroportDep, String aeroportArr, Horaire horaire) {
		super();
		this.modele = modele;
		this.aeroportDep = aeroportDep;
		this.aeroportArr = aeroportArr;
		this.horaire = horaire;
	}
	public Vol(int id, String modele, String aeroportDep, String aeroportArr, Horaire horaire) {
		super();
		this.id = id;
		this.modele = modele;
		this.aeroportDep = aeroportDep;
		this.aeroportArr = aeroportArr;
		this.horaire = horaire;
	}

	//getters et setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public String getAeroportDep() {
		return aeroportDep;
	}

	public void setAeroportDep(String aeroportDep) {
		this.aeroportDep = aeroportDep;
	}

	public String getAeroportArr() {
		return aeroportArr;
	}

	public void setAeroportArr(String aeroportArr) {
		this.aeroportArr = aeroportArr;
	}

	public Horaire getHoraire() {
		return horaire;
	}

	public void setHoraire(Horaire horaire) {
		this.horaire = horaire;
	}

	
	//toString
	@Override
	public String toString() {
		return "Vol [id=" + id + ", modele=" + modele + ", aeroportDep=" + aeroportDep + ", aeroportArr=" + aeroportArr
				+ "]";
	}

}
