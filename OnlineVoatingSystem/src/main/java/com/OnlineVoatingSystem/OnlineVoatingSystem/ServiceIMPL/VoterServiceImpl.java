package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.VoterDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Voter;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoterServiceImpl implements VoterService {

    private final VoterDao voterDao;

    @Autowired
    public VoterServiceImpl(VoterDao voterDao) {
        this.voterDao = voterDao;
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterDao.findAll();
    }

    @Override
    public Optional<Voter> getVoterById(Long id) {
        return voterDao.findById(id);
    }

    @Override
    public Voter addVoter(Voter voter) {
        return voterDao.save(voter);
    }

    @Override
    public Voter updateVoter(Long id, Voter voter) {
        Optional<Voter> existingVoter = voterDao.findById(id);
        if (existingVoter.isPresent()) {
            voter.setVoterID(id); // Set the ID to ensure it updates the existing entity
            return voterDao.save(voter);
        } else {
            throw new RuntimeException("Voter with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteVoter(Long id) {
        if (voterDao.existsById(id)) {
            voterDao.deleteById(id);
        } else {
            throw new RuntimeException("Voter with ID " + id + " not found.");
        }
    }
}
