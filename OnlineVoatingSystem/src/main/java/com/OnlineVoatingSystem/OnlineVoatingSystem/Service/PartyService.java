package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Party;
import java.util.List;
import java.util.Optional;

public interface PartyService {
    List<Party> getAllParties();
    Optional<Party> getPartyById(Long id);
    Party addParty(Party party);
    Party updateParty(Long id, Party party);
    void deleteParty(Long id);
}
