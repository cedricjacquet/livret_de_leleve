/**
 * 
 */
package org.cedricjacquet.rest.api.mvc.controller;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.dao.DomaineRepository;
import org.cedricjacquet.rest.api.model.dao.EleveRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.cedricjacquet.rest.api.model.entity.Domaine;
import org.cedricjacquet.rest.api.model.entity.Eleve;
import org.cedricjacquet.rest.api.model.entity.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cjacquet
 *
 */
@Controller
public class ViewDomainesController {

	
	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	@Autowired
	private DomaineRepository domaineRepository;
	
	
    @RequestMapping("/cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}/domaines/{domaineId}")
    public String niveaux(
    		@PathVariable Integer cycleId,
    		@PathVariable Integer niveauId,
    		@PathVariable Integer eleveId,
    		@PathVariable Integer domaineId,
    		Model model) {
    	Cycle cycle = cycleRepository.findOne(cycleId);
    	Niveau niveau = niveauRepository.findOne(niveauId);
    	Eleve eleve = eleveRepository.findOne(eleveId);
    	Domaine domaine = domaineRepository.findOne(domaineId);
    	if (cycle != null) {
    		model.addAttribute("cycleNom", cycle.getNom());
    		model.addAttribute("cycleId", cycle.getId());
    	}
    	if (niveau != null) {
    		model.addAttribute("niveauNom", niveau.getNom());
    		model.addAttribute("niveauId", niveau.getId());
    	}
    	if (eleve != null) {
    		model.addAttribute("eleveNom", eleve.getNom());
    		model.addAttribute("elevePrenom", eleve.getPrenom());
    		model.addAttribute("eleveId", eleve.getId());
    	}
    	if (domaine != null) {
    		model.addAttribute("domaineNom", domaine.getNom());
    		model.addAttribute("domaineId", domaine.getId());
    	}
        return "domaines";
    }
	
}
