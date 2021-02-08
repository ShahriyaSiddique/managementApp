package com.onik.ManagementApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onik.ManagementApp.models.Contact;
import com.onik.ManagementApp.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;

	public List<Contact> getContacts() {
		return contactRepository.findAll();
	}

	public Optional<Contact> findById(Integer id) {
		return contactRepository.findById(id);
	}

	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	public void deleteById(Integer id) {
		contactRepository.deleteById(id);
	}
}
