package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IAgentDao;
import fr.adaming.model.Agent;

@Service
@Transactional
public class AgentServiceImpl implements IAgentService{

	@Autowired
	private IAgentDao agentDao;
	
	@Override
	public List<Agent> getAllAgents() {
		return agentDao.getAllAgents();
	}

}
