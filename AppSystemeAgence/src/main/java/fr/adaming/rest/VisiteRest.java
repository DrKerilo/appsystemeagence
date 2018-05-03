package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Visite;
import fr.adaming.service.IVisiteService;

@RestController
public class VisiteRest {
	
	@Autowired
	private IVisiteService visiteService;
	
	@RequestMapping(value="/listeVisites", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getAllVisite() {
		return visiteService.getAllVisite();
	}
	
	@RequestMapping(value="/listeVisitesByAgent", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getVisiteByAgent(@RequestParam("pId")int idAgent) {
		return visiteService.getVisiteByAgent(idAgent);
	}

	@RequestMapping(value="/listeVisitesByClient", method=RequestMethod.GET, produces="application/json")
	public List<Visite> getVisiteByClient(@RequestParam("pId")int idClient) {
		return visiteService.getVisiteByClient(idClient);
	}

	@RequestMapping(value="/visite", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Visite addVisite(@RequestBody Visite v) {
		return visiteService.addVisite(v);
	}

	@RequestMapping(value="/visite", method=RequestMethod.PUT, consumes="application/json", produces="application/json")
	public Visite updateVisite(@RequestBody Visite v) {
		return visiteService.updateVisite(v);
	}

	@RequestMapping(value="/visite", method=RequestMethod.DELETE)
	public int deleteVisite(@RequestParam("pId")int id) {
		return visiteService.deleteVisite(id);
	}

}
