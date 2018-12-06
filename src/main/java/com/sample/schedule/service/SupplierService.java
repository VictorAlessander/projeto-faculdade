package com.sample.schedule.service;


import com.sample.schedule.model.Supplier;
import com.sample.schedule.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> findSupplierByName(String name) {
        return this.supplierRepository.findByName(name);
    }

    public Optional<Supplier> findSupplierById(Long id) {
        return this.supplierRepository.findById(id);
    }

    public void removeSupplierById(Long id) {
        this.supplierRepository.deleteById(id);
    }

    public List<Supplier> findAllSuppliers() {
        return this.supplierRepository.findAll();
    }

    public void saveSupplier(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }
}
