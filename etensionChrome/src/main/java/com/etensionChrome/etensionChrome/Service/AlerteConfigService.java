package com.etensionChrome.etensionChrome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etensionChrome.etensionChrome.Entity.AlerteCraConfig;
import com.etensionChrome.etensionChrome.repository.AlertRepository;

@Service
public class AlerteConfigService {
	
	@Autowired
	private AlertRepository alertRepository;
	


	public void save(AlerteCraConfig config) {
		alertRepository.save(config);
		
	}

	
	public List<AlerteCraConfig> getAll(){
		
		return alertRepository.findAll();	
	
	}
	
	public AlerteCraConfig getConfigId(Long id) {
		
		return alertRepository.findById(id).get();
	}
	
	
//	public AlerteCraConfig getfindLast() {
//		return alertRepository.getfindLast();
//	}
	
	
}
