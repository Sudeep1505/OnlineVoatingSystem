package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Voter;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("OVS/voter")
public class VoterController {

    private final VoterService voterService;

    @Autowired
    public VoterController(VoterService voterService) {
        this.voterService = voterService;
    }

    // GET all voters
    @GetMapping
    public ResponseEntity<List<Voter>> getAllVoters() {
        List<Voter> voters = voterService.getAllVoters();
        return new ResponseEntity<>(voters, HttpStatus.OK);
    }

    // GET a specific voter by ID
    @GetMapping("/{id}")
    public ResponseEntity<Voter> getVoterById(@PathVariable Long id) {
        Optional<Voter> voter = voterService.getVoterById(id);
        return voter.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // POST to add a new voter
    @PostMapping
    public ResponseEntity<Voter> addVoter(@RequestBody Voter voter) {
        Voter createdVoter = voterService.addVoter(voter);
        return new ResponseEntity<>(createdVoter, HttpStatus.CREATED);
    }

    // PUT to update an existing voter
    @PutMapping("/{id}")
    public ResponseEntity<Voter> updateVoter(@PathVariable Long id, @RequestBody Voter voter) {
        try {
            Voter updatedVoter = voterService.updateVoter(id, voter);
            return new ResponseEntity<>(updatedVoter, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE to remove a voter by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoter(@PathVariable Long id) {
        try {
            voterService.deleteVoter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
