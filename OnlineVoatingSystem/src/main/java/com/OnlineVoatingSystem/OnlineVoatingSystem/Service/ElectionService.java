package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Election;
import java.util.List;
import java.util.Optional;

public interface ElectionService {
    List<Election> getAllElections();
    Optional<Election> getElectionById(Long id);
    Election addElection(Election election);
    Election updateElection(Long id, Election election);
    void deleteElection(Long id);
}
