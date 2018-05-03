package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Proprietaire;
import fr.adaming.service.IProprietaireService;

@RestController
public class ProprietaireRest {

	// Injection de dépendance
	@Autowired
	private IProprietaireService propService;

	// ----- READ ALL
	@RequestMapping(value = "/listeProprietaire", method = RequestMethod.GET, produces = "application/json")
	public List<Proprietaire> getAllProprietaires() {
		return propService.getAllProprietaire();
	}
	
	// ----- READ BY ID
	@RequestMapping(value="/proprietaire",method=RequestMethod.GET,produces="application/json")
	public Proprietaire getOneProprietaire(@RequestParam("pID") int id){
		return propService.getProprietaireById(id);
	}
	
	// ----- CREATE
	@RequestMapping(value="/proprietaire",method=RequestMethod.POST,produces="application/json",consumes="application/json")
	public Proprietaire addOneProprietaire(@RequestBody Proprietaire p){
		return propService.addProprietaire(p);
	}
	
	// ----- UPDATE
	@RequestMapping(value="/proprietaire",method=RequestMethod.PUT,produces="application/json",consumes="application/json")
	public Proprietaire updateOneProprietaire(@RequestBody Proprietaire p){
		return propService.updateProprietaire(p);
	}
	
	// ----- DELETE
	@RequestMapping(value="/proprietaire/{pID}",method=RequestMethod.DELETE)
	public int deleteOneProprietaire(@PathVariable("pID") int id){
		return propService.deleteProprietaire(id);
	}

}
