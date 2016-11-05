/**
 * 
 */
package org.cedricjacquet.rest.api.mvc.controller;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.cedricjacquet.rest.api.model.entity.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cedri
 *
 */
@Controller
public class ViewNiveauxController {

	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	
    @RequestMapping("/cycles/{cycleId}/niveaux/{niveauId}")
    public String niveaux(
    		@PathVariable Integer cycleId,
    		@PathVariable Integer niveauId, 
    		Model model) {
    	Cycle cycle = cycleRepository.findOne(cycleId);
    	Niveau niveau = niveauRepository.findOne(niveauId);
    	
    	if (cycle != null) {
    		model.addAttribute("cycleNom", cycle.getNom());
    		model.addAttribute("cycleId", cycle.getId());
    	}
    	if (niveau != null) {
    		model.addAttribute("niveauNom", niveau.getNom());
    		model.addAttribute("niveauId", niveau.getId());
    	}
    	
        return "niveaux";
    }
	
}
