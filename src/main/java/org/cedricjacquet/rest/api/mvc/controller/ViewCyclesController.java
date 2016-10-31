package org.cedricjacquet.rest.api.mvc.controller;

import org.cedricjacquet.rest.api.model.dao.CycleRepository;
import org.cedricjacquet.rest.api.model.entity.Cycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewCyclesController {

	@Autowired
	private CycleRepository cycleRepository;
	
	
    @RequestMapping("/cycles/{cycleId}")
    public String cycles(@PathVariable Integer cycleId, Model model) {
    	Cycle cycle = cycleRepository.findOne(cycleId);
    	if (cycle != null) {
    		model.addAttribute("nom", cycle.getNom());
    		model.addAttribute("id", cycle.getId());
    	}
        return "cycles";
    }
	
}
