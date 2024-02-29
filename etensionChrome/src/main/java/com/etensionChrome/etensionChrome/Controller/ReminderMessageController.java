package com.etensionChrome.etensionChrome.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.etensionChrome.etensionChrome.DTO.messageFrontDTO;
import com.etensionChrome.etensionChrome.Entity.Reminder;



@RestController
@CrossOrigin(origins = "chrome-extension://gipjopdimhamkjfecdfmmhokelcadibn", allowedHeaders = "*")
@RequestMapping("/api")
public class ReminderMessageController {
	


	@GetMapping("/sseReminder")
	public SseEmitter sse() {
		SseEmitter emitter = new SseEmitter(-1L);

		SSemitterManager.addEmitter(emitter);
		emitter.onCompletion(() -> {
			System.out.println("Client disconnected!!");
			SSemitterManager.removeEmitter(emitter);
		});

		return emitter;
	}

	@MessageMapping("/notificationReminder")
   // @SendTo("/topic/notificationReminder")
	public ResponseEntity<messageFrontDTO> addReminder(@RequestBody Reminder reminderEnt) {
		
		
		try {

			LocalDate date = reminderEnt.getDate();
	    	String  text = reminderEnt.getText();

			messageFrontDTO message ;

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
			String formattedDate = date.format(formatter);


          long daysDifference = ChronoUnit.DAYS.between(LocalDate.now(), date);

             message = new messageFrontDTO("Nouveau message : "  + text + ", le " + formattedDate + " rappel : " + daysDifference + "jours avant");

			SSemitterManager.sendMessageToAll(message);
    		
		    return ResponseEntity.ok(message);
		} catch (Exception e) {
		    System.err.println("Erreur de formatage de la date : " + e.getMessage());
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}

	}

}
