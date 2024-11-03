package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Vote;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OVS/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    // Get all votes
    @GetMapping
    public ResponseEntity<List<Vote>> getAllVotes() {
        List<Vote> votes = voteService.getAllVotes();
        return new ResponseEntity<>(votes, HttpStatus.OK);
    }

    // Get vote by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id) {
        Optional<Vote> vote = voteService.getVoteById(id);
        return vote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                   .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new vote
    @PostMapping
    public ResponseEntity<Vote> addVote(@RequestBody Vote vote) {
        Vote createdVote = voteService.addVote(vote);
        return new ResponseEntity<>(createdVote, HttpStatus.CREATED);
    }

    // Update an existing vote
    @PutMapping("/{id}")
    public ResponseEntity<Vote> updateVote(@PathVariable Long id, @RequestBody Vote vote) {
        try {
            Vote updatedVote = voteService.updateVote(id, vote);
            return new ResponseEntity<>(updatedVote, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a vote by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVote(@PathVariable Long id) {
        try {
            voteService.deleteVote(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
