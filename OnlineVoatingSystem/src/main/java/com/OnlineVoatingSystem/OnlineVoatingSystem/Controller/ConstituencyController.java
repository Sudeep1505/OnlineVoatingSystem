package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Constituency;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OVS/constituencies")
public class ConstituencyController {

    private final ConstituencyService constituencyService;

    @Autowired
    public ConstituencyController(ConstituencyService constituencyService) {
        this.constituencyService = constituencyService;
    }

    // Get all constituencies
    @GetMapping
    public ResponseEntity<List<Constituency>> getAllConstituencies() {
        List<Constituency> constituencies = constituencyService.getAllConstituencies();
        return new ResponseEntity<>(constituencies, HttpStatus.OK);
    }

    // Get constituency by ID
    @GetMapping("/{id}")
    public ResponseEntity<Constituency> getConstituencyById(@PathVariable Long id) {
        Optional<Constituency> constituency = constituencyService.getConstituencyById(id);
        return constituency.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new constituency
    @PostMapping
    public ResponseEntity<Constituency> addConstituency(@RequestBody Constituency constituency) {
        Constituency createdConstituency = constituencyService.addConstituency(constituency);
        return new ResponseEntity<>(createdConstituency, HttpStatus.CREATED);
    }

    // Update an existing constituency
    @PutMapping("/{id}")
    public ResponseEntity<Constituency> updateConstituency(@PathVariable Long id, @RequestBody Constituency constituency) {
        try {
            Constituency updatedConstituency = constituencyService.updateConstituency(id, constituency);
            return new ResponseEntity<>(updatedConstituency, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a constituency by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConstituency(@PathVariable Long id) {
        try {
            constituencyService.deleteConstituency(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
