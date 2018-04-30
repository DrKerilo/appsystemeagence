package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service("eService")
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;

	@Override
	public Client addClient(Client cl) {
		return clientDao.addClient(cl);
	}

	@Override
	public List<Client> getAllClient(Client cl) {
		return clientDao.getAllClient(cl);
	}

	@Override
	public Client updateClient(Client cl) {

		return clientDao.updateClient(cl);
	}

	@Override
	public int deleteClient() {
		return clientDao.deleteClient();
	}

	@Override
	public Client getClientById(Client cl) {
		return clientDao.getClientById(cl);
	}

}
