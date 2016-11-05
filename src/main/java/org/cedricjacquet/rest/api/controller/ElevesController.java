package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.EleveRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauRepository;
import org.cedricjacquet.rest.api.model.entity.Eleve;
import org.cedricjacquet.rest.api.model.entity.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author cjacquet
 *
 */
@RestController
@RequestMapping("/lde/")
public class ElevesController {

	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves",method = RequestMethod.GET)
	public List<Eleve> getEleves(
			@PathVariable Integer niveauId) {
		Niveau niveau = niveauRepository.findOne(niveauId);
		if (niveau != null) {
			return niveau.getEleves();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}", method = RequestMethod.GET)
	public Eleve getEleve(
			@PathVariable Integer eleveId
			) {
		return eleveRepository.findOne(eleveId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addEleve(
			@PathVariable Integer niveauId,
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "prenom", required = true) String prenom,
			HttpServletRequest request,
			HttpServletResponse response) {
		Niveau niveau = niveauRepository.findOne(niveauId);
		if (niveau != null) {
			Eleve eleve = new Eleve();
			eleve.setNom(nom);
			eleve.setPrenom(prenom);
			eleve.setNiveau(niveau);
			eleveRepository.save(eleve);
			response.setHeader("Location", request.getRequestURL().append("/"+eleve.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateEleve(
			@PathVariable Integer eleveId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "prenom", required = false) String prenom
			)  {
		Eleve eleve = eleveRepository.findOne(eleveId);
		if (eleve != null) {
			if (nom != null) {
				eleve.setNom(nom);
			}
			if (prenom != null) {
				eleve.setPrenom(prenom);
			}
			eleveRepository.save(eleve);
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteEleve(
			@PathVariable Integer eleveId
			) {
		eleveRepository.delete(eleveId);
	}
	
}
