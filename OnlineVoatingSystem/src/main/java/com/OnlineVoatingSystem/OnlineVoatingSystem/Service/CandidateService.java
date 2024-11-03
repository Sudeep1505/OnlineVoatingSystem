package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Candidate;
import java.util.List;
import java.util.Optional;

public interface CandidateService {
    List<Candidate> getAllCandidates();
    Optional<Candidate> getCandidateById(Long id);
    Candidate addCandidate(Candidate candidate);
    Candidate updateCandidate(Long id, Candidate candidate);
    void deleteCandidate(Long id);
}
