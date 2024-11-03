package com.OnlineVoatingSystem.OnlineVoatingSystem.Controller;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Party;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/OVS/parties")
public class PartyController {

    private final PartyService partyService;

    @Autowired
    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    // Get all parties
    @GetMapping
    public ResponseEntity<List<Party>> getAllParties() {
        List<Party> parties = partyService.getAllParties();
        return new ResponseEntity<>(parties, HttpStatus.OK);
    }

    // Get party by ID
    @GetMapping("/{id}")
    public ResponseEntity<Party> getPartyById(@PathVariable Long id) {
        Optional<Party> party = partyService.getPartyById(id);
        return party.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Add a new party
    @PostMapping
    public ResponseEntity<Party> addParty(@RequestBody Party party) {
        Party createdParty = partyService.addParty(party);
        return new ResponseEntity<>(createdParty, HttpStatus.CREATED);
    }

    // Update an existing party
    @PutMapping("/{id}")
    public ResponseEntity<Party> updateParty(@PathVariable Long id, @RequestBody Party party) {
        try {
            Party updatedParty = partyService.updateParty(id, party);
            return new ResponseEntity<>(updatedParty, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a party by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParty(@PathVariable Long id) {
        try {
            partyService.deleteParty(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
