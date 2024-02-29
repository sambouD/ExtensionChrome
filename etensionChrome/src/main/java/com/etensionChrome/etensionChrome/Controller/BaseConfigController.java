package com.etensionChrome.etensionChrome.Controller;


import com.etensionChrome.etensionChrome.DTO.messageFrontDTO;
import com.etensionChrome.etensionChrome.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.etensionChrome.etensionChrome.Service.AlerteConfigService;
import com.etensionChrome.etensionChrome.Service.ReminderService;
import com.etensionChrome.etensionChrome.Service.ScheduledNotificationService;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

@Controller
@CrossOrigin(origins = {"chrome-extension://gipjopdimhamkjfecdfmmhokelcadibn", "http://localhost:4200"}, allowedHeaders = "*")
@RequestMapping("/config")
public class BaseConfigController {

	
	@Autowired
	private AlerteConfigService alerteConfigService;

	@Autowired
	private ReminderService reminderService;

	@Autowired
	private MessageController messageController;

	@Autowired
	private ReminderMessageController reminderMessageController;

	@Autowired
	private ScheduledNotificationService scheduledNotificationService;


   @GetMapping("/form")
    public String configForm(Model model) {
        model.addAttribute("config", new AlerteCraConfig());
        return "configForm";
    }

    @GetMapping("/formReminder")
    public String reminderForm(Model model) {
        model.addAttribute("config", new Reminder());
        return "reminderForm";
    }
    @GetMapping("/formperiod")
    public String formPeriodicite(Model model) {
    	model.addAttribute("config", new Reminder());
    	return "periodiciteForm";
    }


    @PostMapping("/save")
    public String saveConfig(@ModelAttribute AlerteCraConfig config) {

    	config.setChecked(false);


    	messageController.sendNotification(config);

    	scheduledNotificationService.scheduleNotification(config);

    	alerteConfigService.save(config);
    	System.out.println("Testetststse: ");

    	return "redirect:/config/form";
    }


    @PostMapping("/saveReminder")
    public String saveReminder(@ModelAttribute Reminder reminder) {

    	reminderMessageController.addReminder(reminder);

    	System.out.println("Testetststse: ");
    	reminderService.save(reminder);

    	return "redirect:/config/formReminder";
    }


	// Angular Test :




	@PostMapping("/saveTest")
	public ResponseEntity<AlerteCraConfig> saveConfigAngular(@RequestBody AlerteCraConfig config) {

		messageController.sendNotification(config);

		alerteConfigService.save(config);
		System.out.println("Testetststse: ");
		return ResponseEntity.ok(config);
	}

	@PostMapping("/saveTestReminder")
	public ResponseEntity<Reminder> saveReminderCra(@RequestBody Reminder reminder) {

		reminderMessageController.addReminder(reminder);

		reminderService.save(reminder);
		System.out.println("Testetststse: ");
		return ResponseEntity.ok(reminder);
	}







}



