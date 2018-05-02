package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Client;
import fr.adaming.service.IClientService;

@RestController
public class ClientRest {

	@Autowired
	private IClientService clService;

	@RequestMapping(value = "/listeClient", method = RequestMethod.GET, produces = "application/json")
	public List<Client> getAllClients() {
		return clService.getAllClient();
	}

	@RequestMapping(value = "/client/{pId}", method = RequestMethod.GET, produces = "application/json")
	public Client getOneClient(@PathVariable("pId") int id) {
		return clService.getClientById(id);
	}

}
