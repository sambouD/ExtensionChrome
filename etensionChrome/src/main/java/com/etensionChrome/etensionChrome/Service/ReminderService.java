package com.etensionChrome.etensionChrome.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etensionChrome.etensionChrome.Entity.Reminder;
import com.etensionChrome.etensionChrome.repository.ReminderRepository;

@Service
public class ReminderService {

	@Autowired
	private ReminderRepository reminderRepository;
	
	public void save(Reminder reminder) {
		reminderRepository.save(reminder);
	}
}
