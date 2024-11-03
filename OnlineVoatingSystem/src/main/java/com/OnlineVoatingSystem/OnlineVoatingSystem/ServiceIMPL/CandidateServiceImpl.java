package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.CandidateDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Candidate;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateDao candidateDao;

    @Autowired
    public CandidateServiceImpl(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    @Override
    public List<Candidate> getAllCandidates() {
        return candidateDao.findAll();
    }

    @Override
    public Optional<Candidate> getCandidateById(Long id) {
        return candidateDao.findById(id);
    }

    @Override
    public Candidate addCandidate(Candidate candidate) {
        return candidateDao.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Long id, Candidate candidate) {
        Optional<Candidate> existingCandidate = candidateDao.findById(id);
        if (existingCandidate.isPresent()) {
            candidate.setCandidateID(id); // Ensures updating of the existing entity with the same ID
            return candidateDao.save(candidate);
        } else {
            throw new RuntimeException("Candidate with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteCandidate(Long id) {
        if (candidateDao.existsById(id)) {
            candidateDao.deleteById(id);
        } else {
            throw new RuntimeException("Candidate with ID " + id + " not found.");
        }
    }
}
