package com.etensionChrome.etensionChrome.Service;

import com.etensionChrome.etensionChrome.Entity.PeriodiciteEntity;
import com.etensionChrome.etensionChrome.repository.PeriodiciteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodiciteService {

    @Autowired
    private PeriodiciteRepository periodRepository;

    public List<PeriodiciteEntity> getAllPeriodiciteEntities () {
        return periodRepository.findAll();
    }

 public PeriodiciteEntity savePeriodicite(PeriodiciteEntity periodicite) {
        return  periodRepository.save(periodicite);
 }

}
