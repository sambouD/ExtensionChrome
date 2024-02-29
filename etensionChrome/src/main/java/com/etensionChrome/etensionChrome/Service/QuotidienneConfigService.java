package com.etensionChrome.etensionChrome.Service;

import com.etensionChrome.etensionChrome.Entity.QuotidienneConfigEntity;
import com.etensionChrome.etensionChrome.repository.QuotidienneConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuotidienneConfigService {
    @Autowired
    private QuotidienneConfigRepository quotidienneConfigRepository;

//    public QuotidienneConfigEntity getQuotidienneConfig(Long id) {
//        Optional<QuotidienneConfigEntity> configEntity = quotidienneConfigRepository.findById(id);
//        return configEntityOptional.orElse(new QuotidienneConfigEntity()); // Return a new instance if not found
//
//    }

}
