package com.OnlineVoatingSystem.OnlineVoatingSystem.Service;

import com.OnlineVoatingSystem.OnlineVoatingSystem.Entity.Constituency;
import java.util.List;
import java.util.Optional;

public interface ConstituencyService {
    List<Constituency> getAllConstituencies();
    Optional<Constituency> getConstituencyById(Long id);
    Constituency addConstituency(Constituency constituency);
    Constituency updateConstituency(Long id, Constituency constituency);
    void deleteConstituency(Long id);
}
