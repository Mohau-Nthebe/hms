package com.mohau.hms.controller;

import com.mohau.hms.entity.Invoice;
import com.mohau.hms.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.ok(savedInvoice);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<Invoice>> getInvoicesByPatientId(@PathVariable Long patientId) {
        List<Invoice> invoices = invoiceRepository.findByPatientId(patientId);
        return ResponseEntity.ok(invoices);
    }

}
