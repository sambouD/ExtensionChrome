package com.etensionChrome.etensionChrome.Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class Reminder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private String text; 
	private LocalDate date;
	
	
	
	public Reminder() {
	}



	public Reminder(Long id, String text, LocalDate date) {
		this.id = id;
		this.text = text;
		this.date = date;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}

//	public String getFormattedDate() {
//		try {
//			LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME);
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			return localDate.format(formatter);
//		} catch (DateTimeParseException e) {
//			// Gérer les erreurs de format de date
//			return "Date invalide";
//		}
//	}
	
	
	
}
