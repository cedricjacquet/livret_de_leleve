package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.CompetenceRepository;
import org.cedricjacquet.rest.api.model.dao.SousDomaineRepository;
import org.cedricjacquet.rest.api.model.entity.Competence;
import org.cedricjacquet.rest.api.model.entity.SousDomaine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lde/")
public class CompetencesController {

	@Autowired
	private SousDomaineRepository sousDomaineRepository;
	
	@Autowired
	private CompetenceRepository competenceRepository;
	
	
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}/competences",method = RequestMethod.GET)
	public List<Competence> getCompetences(
			@PathVariable Integer sousDomaineId) {
		SousDomaine sousDomaine = sousDomaineRepository.findOne(sousDomaineId);
		if (sousDomaine != null) {
			return sousDomaine.getCompetences();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}/competences/{competenceId}", method = RequestMethod.GET)
	public Competence getCompetence(
			@PathVariable Integer competenceId
			) {
		return competenceRepository.findOne(competenceId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}/competences",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCompetence(
			@PathVariable Integer sousDomaineId,
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "ordreAffichage", required = true) int ordreAffichage,
			HttpServletRequest request,
			HttpServletResponse response) {
		SousDomaine sousDomaine = sousDomaineRepository.findOne(sousDomaineId);
		if (sousDomaine != null) {
			Competence competence = new Competence();
			competence.setNom(nom);
			competence.setOrdreAffichage(ordreAffichage);
			competence.setSousDomaine(sousDomaine);
			competenceRepository.save(competence);
			response.setHeader("Location", request.getRequestURL().append("/"+sousDomaine.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}/competences/{competenceId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateCompetence(
			@PathVariable Integer competenceId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "ordreAffichage", required = false) Integer ordreAffichage
			)  {
		Competence competence = competenceRepository.findOne(competenceId);
		if (competence != null) {
			if (nom != null) {
				competence.setNom(nom);
			}
			if (ordreAffichage != null) {
				competence.setOrdreAffichage(ordreAffichage);
			}
			competenceRepository.save(competence);
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}/competences/{competenceId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCompetence(
			@PathVariable Integer competenceId
			) {
		competenceRepository.delete(competenceId);
	}
	
}
