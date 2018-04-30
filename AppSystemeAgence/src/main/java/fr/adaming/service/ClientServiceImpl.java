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
	public List<Client> getAllClient() {
		return clientDao.getAllClient();
	}

	@Override
	public Client updateClient(Client cl) {

		return clientDao.updateClient(cl);
	}

	@Override
	public int deleteClient(int id) {
		return clientDao.deleteClient(id);
	}

	@Override
	public Client getClientById(int id) {
		return clientDao.getClientById(id);
	}

}
