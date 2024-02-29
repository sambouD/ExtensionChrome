package com.etensionChrome.etensionChrome.Entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class AlerteCraConfig {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	

	private String date;
	private String periode;
	
	private Boolean checked;
	 
	
	public AlerteCraConfig() {

	}
	

	public AlerteCraConfig(Long id, String date, String periode) {
		this.id = id;
		this.date = date;
		this.periode = periode;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriode() {
		return periode;
	}
	public void setPeriode(String periode) {
		this.periode = periode;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public Boolean getChecked() {
		return checked;
	}


	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


	public String getFormattedDate() {
		try {
			LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ISO_DATE_TIME);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			return localDate.format(formatter);
		} catch (DateTimeParseException e) {
			// Gérer les erreurs de format de date
			return "Date invalide";
		}
	}


}
