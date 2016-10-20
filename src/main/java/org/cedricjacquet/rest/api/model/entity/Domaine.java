/**
 * 
 */
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
 * @author cjacquet
 *
 */
@Entity
@Table(name = "Domaine")
public class Domaine extends OrderableEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6180284804680027492L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cycle_id", unique = false, nullable = false)
	private Cycle cycle;
	
	@OneToMany(targetEntity=SousDomaine.class, mappedBy="domaine", cascade=CascadeType.ALL)
	private List<SousDomaine> sousDomaines;


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

	/**
	 * @return the sousDomaines
	 */
	public List<SousDomaine> getSousDomaines() {
		return sousDomaines;
	}

	/**
	 * @param sousDomaines the sousDomaines to set
	 */
	public void setSousDomaines(List<SousDomaine> sousDomaines) {
		this.sousDomaines = sousDomaines;
	}

	
	
}
