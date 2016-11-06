package org.cedricjacquet.rest.api.mvc.controller;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.dao.EleveRepository;
import org.cedricjacquet.rest.api.model.dao.NiveauRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.cedricjacquet.rest.api.model.entity.Eleve;
import org.cedricjacquet.rest.api.model.entity.Niveau;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewElevesController {

	@Autowired
	private CycleRepository cycleRepository;
	
	@Autowired
	private NiveauRepository niveauRepository;
	
	@Autowired
	private EleveRepository eleveRepository;
	
	
    @RequestMapping("/cycles/{cycleId}/niveaux/{niveauId}/eleves/{eleveId}")
    public String niveaux(
    		@PathVariable Integer cycleId,
    		@PathVariable Integer niveauId,
    		@PathVariable Integer eleveId,
    		Model model) {
    	Cycle cycle = cycleRepository.findOne(cycleId);
    	Niveau niveau = niveauRepository.findOne(niveauId);
    	Eleve eleve = eleveRepository.findOne(eleveId);
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
        return "eleves";
    }
	
}