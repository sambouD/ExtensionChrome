package com.etensionChrome.etensionChrome.Controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAdjusters;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.etensionChrome.etensionChrome.DTO.messageFrontDTO;
import com.etensionChrome.etensionChrome.Entity.AlerteCraConfig;

@RestController
@CrossOrigin(origins = {"chrome-extension://gipjopdimhamkjfecdfmmhokelcadibn", "http://localhost:4200"},  allowedHeaders = "*")
@RequestMapping("/api")
public class MessageController {



	@GetMapping("/sse")
	public SseEmitter sse() {
	    SseEmitter emitter = new SseEmitter(-1L);

		SSemitterManager.addEmitter(emitter);
	    emitter.onCompletion(() -> {
	        System.out.println("Client disconnected!!");
			SSemitterManager.removeEmitter(emitter);
	    });
	    
	    return emitter;
	}

     @MessageMapping("/notification")
	public ResponseEntity<messageFrontDTO> sendNotification(@RequestBody AlerteCraConfig config) {
	    try {
	    	
	    	String date =  config.getDate();
	    	String  periode = config.getPeriode();
	    	
	       messageFrontDTO message ;
	        
	    	if(isLastFridayofMonth(date)) {
	    		System.out.println("Le dernier vendredi du mois : " + date);

	    		
  	           message = new messageFrontDTO("Veuillez remplir votre CRA avant " +
					   config.getFormattedDate() + " dans la période " + periode + " !");
             

				SSemitterManager.sendMessageToAll(message);
	    		
	            return ResponseEntity.ok(message);
	    	}
	               return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	           
	    } catch (Exception e) {
		    System.err.println("Erreur de formatage de la date : " + e.getMessage());
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
	
    	




	private boolean isLastFridayofMonth(String dateString) {
		try {
			LocalDate date = LocalDate.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);

			LocalDate lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth());
			LocalDate lastFridayOfMonth = lastDayOfMonth.minusDays(
					(lastDayOfMonth.getDayOfWeek().getValue() + 2) % 7);

			// Vérifie si la date actuelle est le dernier vendredi avant la fin du mois
			return date.getDayOfMonth() == lastFridayOfMonth.getDayOfMonth() &&
					date.getDayOfWeek() == DayOfWeek.FRIDAY;
		} catch (DateTimeParseException e) {
			// Gérer les erreurs de format de date
			return false;
		}
	}


}
