package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Election;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OVS/elections")
public class ElectionController  {

    private final ElectionService electionService;

    @Autowired
    public ElectionController (ElectionService electionService) {
        this.electionService = electionService;
    }

    // Get all elections
    @GetMapping
    public ResponseEntity<List<Election>> getAllElections() {
        List<Election> elections = electionService.getAllElections();
        return new ResponseEntity<>(elections, HttpStatus.OK);
    }

    // Get election by ID
    @GetMapping("/{id}")
    public ResponseEntity<Election> getElectionById(@PathVariable Long id) {
        Optional<Election> election = electionService.getElectionById(id);
        return election.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new election
    @PostMapping
    public ResponseEntity<Election> addElection(@RequestBody Election election) {
        Election createdElection = electionService.addElection(election);
        return new ResponseEntity<>(createdElection, HttpStatus.CREATED);
    }

    // Update an existing election
    @PutMapping("/{id}")
    public ResponseEntity<Election> updateElection(@PathVariable Long id, @RequestBody Election election) {
        try {
            Election updatedElection = electionService.updateElection(id, election);
            return new ResponseEntity<>(updatedElection, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete an election by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElection(@PathVariable Long id) {
        try {
            electionService.deleteElection(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
