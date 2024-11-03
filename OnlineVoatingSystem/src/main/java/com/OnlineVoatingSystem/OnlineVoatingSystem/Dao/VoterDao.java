package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Voter;

public interface VoterDao extends JpaRepository<Voter, Long> {
    // Additional query methods (if needed) can be defined here
}
