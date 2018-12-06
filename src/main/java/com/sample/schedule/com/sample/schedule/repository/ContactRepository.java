package com.sample.schedule.com.sample.schedule.repository;

import com.sample.schedule.com.sample.schedule.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Optional<Contact> findById(Long id);
    List<Contact> findByName(String name);
    void deleteById(Long id);

}
