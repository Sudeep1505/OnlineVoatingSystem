package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.VoteDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Vote;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteDao voteDao;

    @Autowired
    public VoteServiceImpl(VoteDao voteDao) {
        this.voteDao = voteDao;
    }

    @Override
    public List<Vote> getAllVotes() {
        return voteDao.findAll();
    }

    @Override
    public Optional<Vote> getVoteById(Long id) {
        return voteDao.findById(id);
    }

    @Override
    public Vote addVote(Vote vote) {
        return voteDao.save(vote);
    }

    @Override
    public Vote updateVote(Long id, Vote vote) {
        Optional<Vote> existingVote = voteDao.findById(id);
        if (existingVote.isPresent()) {
            vote.setVoteID(id); // Ensures updating of the existing entity with the same ID
            return voteDao.save(vote);
        } else {
            throw new RuntimeException("Vote with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteVote(Long id) {
        if (voteDao.existsById(id)) {
            voteDao.deleteById(id);
        } else {
            throw new RuntimeException("Vote with ID " + id + " not found.");
        }
    }
}
