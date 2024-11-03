package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.AdminDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Admin;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminDao.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminDao.findById(id);
    }

    @Override
    public Admin addAdmin(Admin admin) {
        return adminDao.save(admin);
    }

    @Override
    public Admin updateAdmin(Long id, Admin admin) {
        Optional<Admin> existingAdmin = adminDao.findById(id);
        if (existingAdmin.isPresent()) {
            admin.setAdminID(id); // Ensures updating of the existing entity with the same ID
            return adminDao.save(admin);
        } else {
            throw new RuntimeException("Admin with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteAdmin(Long id) {
        if (adminDao.existsById(id)) {
            adminDao.deleteById(id);
        } else {
            throw new RuntimeException("Admin with ID " + id + " not found.");
        }
    }
}
