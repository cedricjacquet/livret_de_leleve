package org.cedricjacquet.rest.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.cedricjacquet.rest.api.model.dao.DomaineRepository;
import org.cedricjacquet.rest.api.model.dao.SousDomaineRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.cedricjacquet.rest.api.model.entity.Domaine;
import org.cedricjacquet.rest.api.model.entity.SousDomaine;
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
public class SousDomainesController {

	@Autowired
	private SousDomaineRepository sousDomaineRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines",method = RequestMethod.GET)
	public List<SousDomaine> getSousDomaines(
			@PathVariable Integer domaineId) {
		Domaine domaine = domaineRepository.findOne(domaineId);
		if (domaine != null) {
			return domaine.getSousDomaines();
		}
		return new ArrayList<>();
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}", method = RequestMethod.GET)
	public SousDomaine getSousDomaine(
			@PathVariable Integer sousDomaineId
			) {
		return sousDomaineRepository.findOne(sousDomaineId);
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines",  method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addSousDomaine(
			@PathVariable Integer domaineId,
			@RequestParam(name = "nom", required = true) String nom,
			@RequestParam(name = "ordreAffichage", required = true) int ordreAffichage,
			HttpServletRequest request,
			HttpServletResponse response) {
		Domaine domaine = domaineRepository.findOne(domaineId);
		if (domaine != null) {
			SousDomaine sousDomaine = new SousDomaine();
			sousDomaine.setNom(nom);
			sousDomaine.setOrdreAffichage(ordreAffichage);
			sousDomaine.setDomaine(domaine);
			sousDomaineRepository.save(sousDomaine);
			response.setHeader("Location", request.getRequestURL().append("/"+sousDomaine.getId()).toString());
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}",method = RequestMethod.PATCH)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void updateSousDomaine(
			@PathVariable Integer sousDomaineId,
			@RequestParam(name = "nom", required = false) String nom,
			@RequestParam(name = "ordreAffichage", required = false) Integer ordreAffichage
			)  {
		SousDomaine sousDomaine = sousDomaineRepository.findOne(sousDomaineId);
		if (sousDomaine != null) {
			if (nom != null) {
				sousDomaine.setNom(nom);
			}
			if (ordreAffichage != null) {
				sousDomaine.setOrdreAffichage(ordreAffichage);
			}
			sousDomaineRepository.save(sousDomaine);
		}
	}
	
	@RequestMapping(value = "cycles/{cycleId}/domaines/{domaineId}/sousdomaines/{sousDomaineId}",method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteClusterV1(
			@PathVariable Integer sousDomaineId
			) {
		sousDomaineRepository.delete(sousDomaineId);
	}
	
}
