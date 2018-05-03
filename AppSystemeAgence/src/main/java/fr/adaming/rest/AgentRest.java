package fr.adaming.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.adaming.model.Agent;
import fr.adaming.service.IAgentService;

@RestController
public class AgentRest {
	
	@Autowired
	private IAgentService agentService;
	
	@RequestMapping(value="/listeAgents", method=RequestMethod.GET, produces="application/json")
	public List<Agent> getAllAgents() {
		return agentService.getAllAgents();
	}

}
