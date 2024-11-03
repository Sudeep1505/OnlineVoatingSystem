package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Vote;

public interface VoteDao extends JpaRepository<Vote, Long> {
    // Custom query methods (if needed) can be defined here
}
