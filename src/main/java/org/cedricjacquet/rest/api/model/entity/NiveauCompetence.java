package org.cedricjacquet.rest.api.model.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author cjacquet
 *
 */
@Entity
@Table(name = "NiveauCompetence")
public class NiveauCompetence extends IdentifiableEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6674068389712289396L;
	
	@Column(name = "niveau", unique = false, nullable = false)
	private int niveau;
	
	@Column(name = "date_creation", unique = false, nullable = false)
	private Timestamp dateCreation;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "competence_id", unique = false, nullable = false)
	private Competence competence;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eleve_id", unique = false, nullable = false)
	private Eleve eleve;
	/**
	 * @return the niveau
	 */
	public int getNiveau() {
		return niveau;
	}
	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	/**
	 * @return the dateCreation
	 */
	public Timestamp getDateCreation() {
		return dateCreation;
	}
	/**
	 * @param dateCreation the dateCreation to set
	 */
	public void setDateCreation(Timestamp dateCreation) {
		this.dateCreation = dateCreation;
	}
	/**
	 * @return the competence
	 */
	public Competence getCompetence() {
		return competence;
	}
	/**
	 * @param competence the competence to set
	 */
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	/**
	 * @return the eleve
	 */
	public Eleve getEleve() {
		return eleve;
	}
	/**
	 * @param eleve the eleve to set
	 */
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	
}
