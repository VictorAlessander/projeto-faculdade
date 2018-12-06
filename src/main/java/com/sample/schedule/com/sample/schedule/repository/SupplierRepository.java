package com.sample.schedule.com.sample.schedule.repository;

import com.sample.schedule.com.sample.schedule.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    void deleteById(Long id);
    Optional<Supplier> findById(Long id);
    List<Supplier> findByName(String name);
}
