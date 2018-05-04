package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.adaming.model.Contrat;
import fr.adaming.service.IContratService;

public class ContratRest {
	
	@Autowired
	private IContratService contratService;
	
	@RequestMapping(value = "/listeContrat", method = RequestMethod.GET, produces = "application/json")
	public List<Contrat> getAllContrats() {
		return contratService.getAllContrat();
	}
	
	@RequestMapping(value = "/contratAdd", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public Contrat addContrat(@RequestBody Contrat cont) {
		return contratService.addContrat(cont);
	}
	
	@RequestMapping(value = "/contratUpdate", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public Contrat updateContrat(@RequestBody Contrat cont) {
		return contratService.updateContrat(cont);
	}

	@RequestMapping(value = "/deleteContrat/{pId}", method = RequestMethod.DELETE)
	public int deleteContrat(@PathVariable("pId") int id) {
		return contratService.deleteContrat(id);
	}

}
