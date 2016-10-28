package org.cedricjacquet.rest.api.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
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
@RequestMapping("/lde/cycles")
public class CyclesController {

	@Autowired
	private CycleRepository cycleRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Cycle> getCycles() {
		return cycleRepository.findAll();
	}
	
	@RequestMapping(value = "/{cycleId}", method = RequestMethod.GET)
	public Cycle getCycle(
			@PathVariable Integer cycleId
			) {
		return cycleRepository.findOne(cycleId);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addCycle(
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "ordreAffichage", required = true) int ordreAffichage,
			HttpServletRequest request,
			HttpServletResponse response) {
		Cycle cycle = new Cycle();
		cycle.setNom(nom);
		cycle.setOrdreAffichage(ordreAffichage);
		cycleRepository.save(cycle);
		response.setHeader("Location", request.getRequestURL().append("/"+cycle.getId()).toString());
	}
	
	@RequestMapping(value = "/{cycleId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateCycle(
			@PathVariable Integer cycleId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "ordreAffichage", required = false) Integer ordreAffichage
			)  {
		Cycle cycle = cycleRepository.findOne(cycleId);
		if (cycle != null) {
			if (nom != null) {
				cycle.setNom(nom);
			}
			if (ordreAffichage != null) {
				cycle.setOrdreAffichage(ordreAffichage);
			}
			cycleRepository.save(cycle);
		}
	}
	
	@RequestMapping(value = "/{cycleId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteCycle(
			@PathVariable Integer cycleId
			) {
		cycleRepository.delete(cycleId);
	}
	
}