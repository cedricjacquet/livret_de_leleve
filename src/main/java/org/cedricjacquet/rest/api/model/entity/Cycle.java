package org.cedricjacquet.rest.api.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author cjacquet
 *
 */
@Entity
@Table(name = "Cycle")
public class Cycle extends OrderableEntity implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8265164845639362548L;

	@JsonIgnore
	@OneToMany(targetEntity=Niveau.class, mappedBy="cycle", cascade=CascadeType.ALL)
	private List<Niveau> niveaux;
	
	@JsonIgnore
	@OneToMany(targetEntity=Domaine.class, mappedBy="cycle", cascade=CascadeType.ALL)
	private List<Domaine> domaines;

	/**
	 * @return the niveaux
	 */
	public List<Niveau> getNiveaux() {
		return niveaux;
	}

	/**
	 * @param niveaux the niveaux to set
	 */
	public void setNiveaux(List<Niveau> niveaux) {
		this.niveaux = niveaux;
	}

	/**
	 * @return the domaines
	 */
	public List<Domaine> getDomaines() {
		return domaines;
	}

	/**
	 * @param domaines the domaines to set
	 */
	public void setDomaines(List<Domaine> domaines) {
		this.domaines = domaines;
	}
	
	
}
