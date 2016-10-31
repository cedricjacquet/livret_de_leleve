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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author cjacquet
 *
 */
@Entity
@Table(name = "SousDomaine")
public class SousDomaine extends OrderableEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5676902241793811380L;

	@JsonIgnore
	@OneToMany(targetEntity=Competence.class, mappedBy="sousDomaine", cascade=CascadeType.ALL)
	private List<Competence> competences;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "domaine_id", unique = false, nullable = false)
	private Domaine domaine;

	/**
	 * @return the competences
	 */
	public List<Competence> getCompetences() {
		return competences;
	}
	/**
	 * @param competences the competences to set
	 */
	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}
	/**
	 * @return the domaine
	 */
	public Domaine getDomaine() {
		return domaine;
	}
	/**
	 * @param domaine the domaine to set
	 */
	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	

}
