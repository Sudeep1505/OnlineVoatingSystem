package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Voter;
import java.util.List;
import java.util.Optional;

public interface VoterService {
    List<Voter> getAllVoters();
    Optional<Voter> getVoterById(Long id);
    Voter addVoter(Voter voter);
    Voter updateVoter(Long id, Voter voter);
    void deleteVoter(Long id);
}
