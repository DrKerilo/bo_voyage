package fr.adaming.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class Horaire {

	@Temporal(TemporalType.DATE)
	private Date dateDep;
	@Temporal(TemporalType.DATE)
	private Date dateRet;
	@Temporal(TemporalType.TIME)
	private Date heureDep;
	@Temporal(TemporalType.TIME)
	private Date heureRet;

	// Constructeurs
	public Horaire() {
		super();
	}

	public Horaire(Date dateDep, Date dateRet, Date heureDep, Date heureRet) {
		super();
		this.dateDep = dateDep;
		this.dateRet = dateRet;
		this.heureDep = heureDep;
		this.heureRet = heureRet;
	}

	// Getter et setter
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

	public Date getHeureDep() {
		return heureDep;
	}

	public void setHeureDep(Date heureDep) {
		this.heureDep = heureDep;

	}

	public Date getHeureRet() {
		return heureRet;
	}

	public void setHeureRet(Date heureRet) {
		this.heureRet = heureRet;
	}

}
