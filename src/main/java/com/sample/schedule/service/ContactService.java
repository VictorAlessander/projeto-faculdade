package com.sample.schedule.service;


import com.sample.schedule.model.Contact;
import com.sample.schedule.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContactByName(String name) {
        return this.contactRepository.findByName(name);
    }

    public void deleteContactById(Long id) {
        this.contactRepository.deleteById(id);
    }

    public Optional<Contact> findContactById(Long id) {
        return this.contactRepository.findById(id);
    }

    public List<Contact> listAllContacts() {
        return this.contactRepository.findAll();
    }

    public void saveContact(Contact contact) {
        this.contactRepository.save(contact);
    }
}
