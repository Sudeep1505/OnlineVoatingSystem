package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Candidate;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OVS/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    // Get all candidates
    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        return new ResponseEntity<>(candidates, HttpStatus.OK);
    }

    // Get candidate by ID
    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id) {
        Optional<Candidate> candidate = candidateService.getCandidateById(id);
        return candidate.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                        .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new candidate
    @PostMapping
    public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate) {
        Candidate createdCandidate = candidateService.addCandidate(candidate);
        return new ResponseEntity<>(createdCandidate, HttpStatus.CREATED);
    }

    // Update an existing candidate
    @PutMapping("/{id}")
    public ResponseEntity<Candidate> updateCandidate(@PathVariable Long id, @RequestBody Candidate candidate) {
        try {
            Candidate updatedCandidate = candidateService.updateCandidate(id, candidate);
            return new ResponseEntity<>(updatedCandidate, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a candidate by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCandidate(@PathVariable Long id) {
        try {
            candidateService.deleteCandidate(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
