package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Vote;
import java.util.List;
import java.util.Optional;

public interface VoteService {
    List<Vote> getAllVotes();
    Optional<Vote> getVoteById(Long id);
    Vote addVote(Vote vote);
    Vote updateVote(Long id, Vote vote);
    void deleteVote(Long id);
}
