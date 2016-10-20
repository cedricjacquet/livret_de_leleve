/**
 * 
 */
package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.dao.DomaineRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.cedricjacquet.rest.api.model.entity.Domaine;
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
public class DomainesController {

	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	@RequestMapping(value = "cycles/{cycleId}/domaines",method = RequestMethod.GET)
	public List<Domaine> getDomaines(@PathVariable Integer cycleId) {
		Cycle cycle = cycleRepository.findOne(cycleId);
		if (cycle != null) {
			return cycle.getDomaines();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}", method = RequestMethod.GET)
	public Domaine getDomaine(
			@PathVariable Integer cycleId,
			@PathVariable Integer domaineId
			) {
		return domaineRepository.findOne(domaineId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addDomaine(
			@PathVariable Integer cycleId,
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "ordreAffichage", required = true) int ordreAffichage,
			HttpServletRequest request,
			HttpServletResponse response) {
		Cycle cycle = cycleRepository.findOne(cycleId);
		if (cycle != null) {
			Domaine domaine = new Domaine();
			domaine.setNom(nom);
			domaine.setOrdreAffichage(ordreAffichage);
			domaine.setCycle(cycle);
			domaineRepository.save(domaine);
			response.setHeader("Location", request.getRequestURL().append("/"+domaine.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateDomaine(
			@PathVariable Integer cycleId,
			@PathVariable Integer domaineId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "ordreAffichage", required = false) Integer ordreAffichage
			)  {
		Domaine domaine = domaineRepository.findOne(domaineId);
		if (domaine != null) {
			if (nom != null) {
				domaine.setNom(nom);
			}
			if (ordreAffichage != null) {
				domaine.setOrdreAffichage(ordreAffichage);
			}
			domaineRepository.save(domaine);
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteClusterV1(
			@PathVariable Integer cycleId,
			@PathVariable Integer domaineId
			) {
		domaineRepository.delete(domaineId);
	}
	
}
