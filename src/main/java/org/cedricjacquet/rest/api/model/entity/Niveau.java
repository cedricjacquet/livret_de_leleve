package org.cedricjacquet.rest.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name = "Niveau")
public class Niveau extends OrderableEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1535196726713600203L;
	
	@OneToMany(targetEntity=Eleve.class, mappedBy="niveau", cascade=CascadeType.ALL)
	private List<Eleve> eleves;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cycle_id", unique = false, nullable = false)
	private Cycle cycle;

	
	/**
	 * @return the eleves
	 */
	public List<Eleve> getEleves() {
		return eleves;
	}
	/**
	 * @param eleves the eleves to set
	 */
	public void setEleves(List<Eleve> eleves) {
		this.eleves = eleves;
	}
	/**
	 * @return the cycle
	 */
	public Cycle getCycle() {
		return cycle;
	}
	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}
	
	
	
}
