package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Constituency;

public interface ConstituencyDao extends JpaRepository<Constituency, Long> {
    // Custom query methods (if needed) can be defined here
}
