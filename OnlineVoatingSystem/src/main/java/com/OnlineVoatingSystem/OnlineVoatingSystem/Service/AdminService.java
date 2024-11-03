package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Admin;
import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> getAllAdmins();
    Optional<Admin> getAdminById(Long id);
    Admin addAdmin(Admin admin);
    Admin updateAdmin(Long id, Admin admin);
    void deleteAdmin(Long id);
}
