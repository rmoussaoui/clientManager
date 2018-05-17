package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Client;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	
	@Override
	public List<Client> getAllClients() {
		return (List<Client>) clientRepository.findAll();
	}

	@Override
	public Client getClientById(Long clientId) {
		Optional<Client> optClient = clientRepository.findById(clientId);
		return optClient.isPresent() ? optClient.get() : null;
	}

	@Override
	public void updateClient(Client clientParam) {
		Optional<Client> optClient = clientRepository.findById(clientParam.getClientId());
		
		if (optClient.isPresent()) {
			Client client = optClient.get();
			client.setName(clientParam.getName());
			client.setBirthDate(clientParam.getBirthDate());
			clientRepository.save(client);
		}
	}

}
