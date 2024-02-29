package com.etensionChrome.etensionChrome.Service;

import java.time.LocalDateTime;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.etensionChrome.etensionChrome.Entity.AlerteCraConfig;
import com.etensionChrome.etensionChrome.Entity.ScheduledNotification;
import com.etensionChrome.etensionChrome.repository.ScheduledNotificationRepository;

@Service
public class ScheduledNotificationService {
	
	@Autowired
	private ScheduledNotificationRepository repository;
	

	

	
	
	public void scheduleNotification(AlerteCraConfig config) {
		
		ScheduledNotification scheduledNotification = new ScheduledNotification();
		
		scheduledNotification.setConfigId(config.getId());
	
        scheduledNotification.setScheduledTime(LocalDateTime.now().plusMinutes(2));
    
        
        repository.save(scheduledNotification);
        
  scheduleRepeatedNotifications(config.getId(), LocalDateTime.now().plusMinutes(2), 1); // Example: Repeat 5 times every 2 minutes

      
	}

	
	private void scheduleRepeatedNotifications(Long configId, LocalDateTime initialTime, int repeatCount) {
	    for (int i = 1; i <= repeatCount; i++) {
	        ScheduledNotification repeatedNotification = new ScheduledNotification();
	        
	        // Set the same configId for the repeated notification
	        repeatedNotification.setConfigId(configId);
	        
	        // Calculate the next scheduled time based on the interval
	        LocalDateTime nextScheduledTime = initialTime.plusMinutes(2 * i); // Adjust the interval as needed
	        
	        repeatedNotification.setScheduledTime(nextScheduledTime);
	        
	        // Save the repeated notification
	        repository.save(repeatedNotification);
	    }
	}
}
