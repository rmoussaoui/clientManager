package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Client;

public interface ClientService {
	
	List<Client> getAllClients();
	
	Client getClientById(Long clientId);
	
	void updateClient(Client client);
}
