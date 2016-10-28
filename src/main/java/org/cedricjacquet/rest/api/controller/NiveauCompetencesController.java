/**
 * 
 */
package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.CompetenceRepository;
import org.cedricjacquet.rest.api.model.dao.EleveRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauCompetenceRepository;
import org.cedricjacquet.rest.api.model.entity.Competence;
import org.cedricjacquet.rest.api.model.entity.Eleve;
import org.cedricjacquet.rest.api.model.entity.NiveauCompetence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cjacquet
 *
 */
@RestController
@RequestMapping("/lde/")
public class NiveauCompetencesController {

	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private NiveauCompetenceRepository niveauCompetenceRepository;
	
	@Autowired
	private CompetenceRepository competenceRepository;
	
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}/niveaucompetences",method = RequestMethod.GET)
	public List<NiveauCompetence> getNiveauCompetences(
			@PathVariable Integer eleveId) {
		Eleve eleve = eleveRepository.findOne(eleveId);
		if (eleve != null) {
			return eleve.getNiveauCompetences();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}/niveaucompetences/{niveauCompetenceId}", method = RequestMethod.GET)
	public NiveauCompetence getNiveauCompetence(
			@PathVariable Integer niveauCompetenceId
			) {
		return niveauCompetenceRepository.findOne(niveauCompetenceId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}/niveaucompetences",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addNiveauCompetence(
			@PathVariable Integer eleveId,
			@RequestParam(name = "competenceId", required = true) Integer competenceId,
			@RequestParam(name = "niveau", required = true) Integer niveau,
			HttpServletRequest request,
			HttpServletResponse response) {
		Eleve eleve = eleveRepository.findOne(eleveId);
		Competence competence = competenceRepository.findOne(competenceId);
		if (eleve != null && competence != null) {
			NiveauCompetence niveauCompetence = new NiveauCompetence();
			niveauCompetence.setEleve(eleve);
			niveauCompetence.setCompetence(competence);
			Calendar calendar = Calendar.getInstance();
			niveauCompetence.setDateCreation(new java.sql.Timestamp(calendar.getTime().getTime()));
			niveauCompetenceRepository.save(niveauCompetence);
			response.setHeader("Location", request.getRequestURL().append("/"+niveauCompetence.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}/niveaucompetences/{niveauCompetenceId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteNiveauCompetence(
			@PathVariable Integer niveauCompetenceId
			) {
		niveauCompetenceRepository.delete(niveauCompetenceId);
	}
	
}