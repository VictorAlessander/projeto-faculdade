package com.sample.schedule.controller;


import com.sample.schedule.com.sample.schedule.model.Contact;
import com.sample.schedule.com.sample.schedule.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contact")
public class ContactController {

    private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        this.contactService.deleteContactById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Contact> queryset = this.contactService.findContactById(id);

        return new ResponseEntity<>(queryset, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<Contact> queryset = this.contactService.getContactByName(name);

        return new ResponseEntity<>(queryset, HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact) {
        this.contactService.saveContact(contact);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> listAllContacts() {
        List<Contact> queryset = this.contactService.listAllContacts();

        return new ResponseEntity<>(queryset, HttpStatus.OK);
    }

}
