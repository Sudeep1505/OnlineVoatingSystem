package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Election;

public interface ElectionDao extends JpaRepository<Election, Long> {
    // Custom query methods (if needed) can be defined here
}
