package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.ElectionDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Election;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ElectionServiceImpl implements ElectionService {

    private final ElectionDao electionDao;

    @Autowired
    public ElectionServiceImpl(ElectionDao electionDao) {
        this.electionDao = electionDao;
    }

    @Override
    public List<Election> getAllElections() {
        return electionDao.findAll();
    }

    @Override
    public Optional<Election> getElectionById(Long id) {
        return electionDao.findById(id);
    }

    @Override
    public Election addElection(Election election) {
        return electionDao.save(election);
    }

    @Override
    public Election updateElection(Long id, Election election) {
        Optional<Election> existingElection = electionDao.findById(id);
        if (existingElection.isPresent()) {
            election.setElectionID(id); // Ensures updating of the existing entity with the same ID
            return electionDao.save(election);
        } else {
            throw new RuntimeException("Election with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteElection(Long id) {
        if (electionDao.existsById(id)) {
            electionDao.deleteById(id);
        } else {
            throw new RuntimeException("Election with ID " + id + " not found.");
        }
    }
}
