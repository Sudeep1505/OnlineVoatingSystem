package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Party;

public interface PartyDao extends JpaRepository<Party, Long> {
    // Custom query methods (if needed) can be defined here
}
