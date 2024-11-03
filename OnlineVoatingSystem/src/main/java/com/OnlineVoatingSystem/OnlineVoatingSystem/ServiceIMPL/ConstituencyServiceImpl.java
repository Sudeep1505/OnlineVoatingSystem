package com.OnlineVoatingSystem.OnlineVoatingSystem.ServiceIMPL;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Dao.ConstituencyDao;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Constituency;
import com.OnlineVoatingSystem.OnlineVoatingSystem.Service.ConstituencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConstituencyServiceImpl implements ConstituencyService {

    private final ConstituencyDao constituencyDao;

    @Autowired
    public ConstituencyServiceImpl(ConstituencyDao constituencyDao) {
        this.constituencyDao = constituencyDao;
    }

    @Override
    public List<Constituency> getAllConstituencies() {
        return constituencyDao.findAll();
    }

    @Override
    public Optional<Constituency> getConstituencyById(Long id) {
        return constituencyDao.findById(id);
    }

    @Override
    public Constituency addConstituency(Constituency constituency) {
        return constituencyDao.save(constituency);
    }

    @Override
    public Constituency updateConstituency(Long id, Constituency constituency) {
        Optional<Constituency> existingConstituency = constituencyDao.findById(id);
        if (existingConstituency.isPresent()) {
            constituency.setConstituencyID(id); // Ensures updating of the existing entity with the same ID
            return constituencyDao.save(constituency);
        } else {
            throw new RuntimeException("Constituency with ID " + id + " not found.");
        }
    }

    @Override
    public void deleteConstituency(Long id) {
        if (constituencyDao.existsById(id)) {
            constituencyDao.deleteById(id);
        } else {
            throw new RuntimeException("Constituency with ID " + id + " not found.");
        }
    }
}
