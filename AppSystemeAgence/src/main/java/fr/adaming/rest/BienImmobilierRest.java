package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.BienImmobilier;
import fr.adaming.service.IBienImmobilierService;

@RestController
public class BienImmobilierRest {

	@Autowired
	private IBienImmobilierService bmService;

	@RequestMapping(value = "/bienImmo", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public BienImmobilier addBienImmobilier(@RequestBody BienImmobilier b) {
		return bmService.addBienImmobilier(b);
	}

	@RequestMapping(value = "/bienImmo", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
	public BienImmobilier editBienImmobilier(@RequestBody BienImmobilier b) {
		return bmService.editBienImmobilier(b);
	}

	@RequestMapping(value = "/bienImmo/{pId}", method = RequestMethod.DELETE)
	public int deleteBienImmobilier(@PathVariable("pId") int id) {
		return bmService.deleteBienImmobilier(id);
	}

	@RequestMapping(value = "/bienImmo", method = RequestMethod.GET, produces = "application/json")
	public BienImmobilier getBienById(@RequestParam("pId") int id) {
		return bmService.getBienById(id);
	}

	@RequestMapping(value = "/listeBI", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getAllBienImmobilier() {
		return bmService.getAllBienImmobilier();
	}

	@RequestMapping(value = "/listeBIByClasse/{pId}", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getBiensByClasse(@PathVariable("pId") int id) {
		return bmService.getBiensByClasse(id);
	}

	@RequestMapping(value = "/listeBIByProprietaire/{pId}", method = RequestMethod.GET, produces = "application/json")
	public List<BienImmobilier> getBiensByProprio(@PathVariable("pId") int id) {
		return bmService.getBiensByProprietaire(id);
	}
}
