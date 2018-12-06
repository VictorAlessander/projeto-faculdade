package com.sample.schedule.controller;


import com.sample.schedule.com.sample.schedule.model.Supplier;
import com.sample.schedule.com.sample.schedule.service.SupplierService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<?> findByName(@PathVariable String name) {
        List<Supplier> queryset = this.supplierService.findSupplierByName(name);

        return new ResponseEntity<>(queryset, HttpStatus.FOUND);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Supplier> queryset = this.supplierService.findSupplierById(id);

        return new ResponseEntity<>(queryset, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeById(@PathVariable Long id) {
        this.supplierService.removeSupplierById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateSupplier(@RequestBody Supplier supplier) {
        this.supplierService.saveSupplier(supplier);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplier) {
        this.supplierService.saveSupplier(supplier);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<?> findAllSuppliers() {
        List<Supplier> queryset = this.supplierService.findAllSuppliers();

        return new ResponseEntity<>(queryset, HttpStatus.OK);
    }

}
