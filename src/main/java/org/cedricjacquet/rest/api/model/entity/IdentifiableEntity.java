package org.cedricjacquet.rest.api.model.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * @author cjacquet
 *
 */
@MappedSuperclass
public abstract class IdentifiableEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
