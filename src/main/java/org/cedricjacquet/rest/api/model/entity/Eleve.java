package org.cedricjacquet.rest.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author cjacquet
 *
 */
@Entity
@Table(name = "Eleve")
public class Eleve extends IdentifiableEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9185137509234921703L;
	
	@Column(name = "nom", unique = false, nullable = false)
	private String nom;
	
	@Column(name = "prenom", unique = false, nullable = false)
	private String prenom;
	
	@OneToMany(targetEntity=NiveauCompetence.class, mappedBy="eleve", cascade=CascadeType.ALL)
	private List<NiveauCompetence> niveauCompetences;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "niveau_id", unique = false, nullable = false)
	private Niveau niveau;
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return the niveauCompetences
	 */
	public List<NiveauCompetence> getNiveauCompetences() {
		return niveauCompetences;
	}
	/**
	 * @param niveauCompetences the niveauCompetences to set
	 */
	public void setNiveauCompetences(List<NiveauCompetence> niveauCompetences) {
		this.niveauCompetences = niveauCompetences;
	}
	/**
	 * @return the niveau
	 */
	public Niveau getNiveau() {
		return niveau;
	}
	/**
	 * @param niveau the niveau to set
	 */
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	
}
