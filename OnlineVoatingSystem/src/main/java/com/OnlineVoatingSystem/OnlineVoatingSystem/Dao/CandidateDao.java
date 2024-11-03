package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Long> {
    // Custom query methods (if needed) can be defined here
}
