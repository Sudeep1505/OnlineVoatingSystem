package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.PartyDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Party;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartyServiceImpl implements PartyService {

    private final PartyDao partyDao;

    @Autowired
    public PartyServiceImpl(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    @Override
    public List<Party> getAllParties() {
        return partyDao.findAll();
    }

    @Override
    public Optional<Party> getPartyById(Long id) {
        return partyDao.findById(id);
    }

    @Override
    public Party addParty(Party party) {
        return partyDao.save(party);
    }

    @Override
    public Party updateParty(Long id, Party party) {
        Optional<Party> existingParty = partyDao.findById(id);
        if (existingParty.isPresent()) {
            party.setPartyID(id); // Ensures updating of the existing entity with the same ID
            return partyDao.save(party);
        } else {
            throw new RuntimeException("Party with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteParty(Long id) {
        if (partyDao.existsById(id)) {
            partyDao.deleteById(id);
        } else {
            throw new RuntimeException("Party with ID " + id + " not found.");
        }
    }
}
