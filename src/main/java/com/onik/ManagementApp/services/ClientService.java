package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Client;
import com.onik.ManagementApp.repositories.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> getClients() {
		return clientRepository.findAll();
	}

	public Optional<Client> findById(Integer id) {
		return clientRepository.findById(id);
	}

	public void save(Client client) {
		clientRepository.save(client);
	}

	public void deleteById(Integer id) {
		clientRepository.deleteById(id);
	}
}
