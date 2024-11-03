package com.OnlineVoatingSystem.OnlineVoatingSystem.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Long> {
    // Custom query methods (if needed) can be defined here
}
