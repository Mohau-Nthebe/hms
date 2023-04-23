package com.mohau.hms.controller;

import com.mohau.hms.entity.Ward;
import com.mohau.hms.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wards")
public class WardController {

    @Autowired
    private WardRepository wardRepository;

    @PostMapping
    public ResponseEntity<Ward> createWard(@RequestBody Ward ward) {
        Ward savedWard = wardRepository.save(ward);
        return new ResponseEntity<>(savedWard, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ward> getWardById(@PathVariable Long id) {
        Ward ward = wardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ward not found with id " + id));
        return new ResponseEntity<>(ward, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ward> updateWard(@PathVariable Long id, @RequestBody Ward wardToUpdate) {
        Ward existingWard = wardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ward not found with id " + id));

        existingWard.setWardNumber(wardToUpdate.getWardNumber());

        Ward updatedWard = wardRepository.save(existingWard);
        return new ResponseEntity<>(updatedWard, HttpStatus.OK);
    }
}
