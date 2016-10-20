package org.cedricjacquet.rest.api.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author cjacquet
 *
 */
@Entity
@Table(name = "Competence")
public class Competence extends OrderableEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4247173717741296757L;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sousdomaine_id", unique = false, nullable = false)
	private SousDomaine sousDomaine;


	/**
	 * @return the sousDomaine
	 */
	public SousDomaine getSousDomaine() {
		return sousDomaine;
	}

	/**
	 * @param sousDomaine the sousDomaine to set
	 */
	public void setSousDomaine(SousDomaine sousDomaine) {
		this.sousDomaine = sousDomaine;
	}
	
	
	
}
