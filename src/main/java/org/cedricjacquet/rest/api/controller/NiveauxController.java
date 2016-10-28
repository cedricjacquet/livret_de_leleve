/**
 * 
 */
package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
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
 * @author cjacquet
 *
 */
@RestController
@RequestMapping("/lde/")
public class NiveauxController {
	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux",method = RequestMethod.GET)
	public List<Niveau> getNiveaux(@PathVariable Integer cycleId) {
		Cycle cycle = cycleRepository.findOne(cycleId);
		if (cycle != null) {
			return cycle.getNiveaux();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}", method = RequestMethod.GET)
	public Niveau getNiveau(
			@PathVariable Integer cycleId,
			@PathVariable Integer niveauId
			) {
		return niveauRepository.findOne(niveauId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addNiveau(
			@PathVariable Integer cycleId,
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "ordreAffichage", required = true) int ordreAffichage,
			HttpServletRequest request,
			HttpServletResponse response) {
		Cycle cycle = cycleRepository.findOne(cycleId);
		if (cycle != null) {
			Niveau niveau = new Niveau();
			niveau.setNom(nom);
			niveau.setOrdreAffichage(ordreAffichage);
			niveau.setCycle(cycle);
			niveauRepository.save(niveau);
			response.setHeader("Location", request.getRequestURL().append("/"+niveau.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateNiveau(
			@PathVariable Integer cycleId,
			@PathVariable Integer niveauId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "ordreAffichage", required = false) Integer ordreAffichage
			)  {
		Niveau niveau = niveauRepository.findOne(niveauId);
		if (niveau != null) {
			if (nom != null) {
				niveau.setNom(nom);
			}
			if (ordreAffichage != null) {
				niveau.setOrdreAffichage(ordreAffichage);
			}
			niveauRepository.save(niveau);
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/niveaux/{niveauId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteNiveau(
			@PathVariable Integer cycleId,
			@PathVariable Integer niveauId
			) {
		niveauRepository.delete(niveauId);
	}
}
