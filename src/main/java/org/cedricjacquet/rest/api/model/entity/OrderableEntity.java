package org.cedricjacquet.rest.api.model.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author cjacquet
 *
 */
@MappedSuperclass
public abstract class OrderableEntity extends IdentifiableEntity {

	@Column(name = "nom", unique = false, nullable = false)
	private String nom;
	
	@Column(name = "ordre_affichage", unique = false, nullable = false)
	private int ordreAffichage;

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
	 * @return the ordreAffichage
	 */
	public int getOrdreAffichage() {
		return ordreAffichage;
	}

	/**
	 * @param ordreAffichage the ordreAffichage to set
	 */
	public void setOrdreAffichage(int ordreAffichage) {
		this.ordreAffichage = ordreAffichage;
	}
	
	
	
}
