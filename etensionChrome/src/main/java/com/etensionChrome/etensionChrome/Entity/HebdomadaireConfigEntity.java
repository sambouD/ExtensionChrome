package com.etensionChrome.etensionChrome.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class HebdomadaireConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	private Long NombresDeSemaines;
	private String periodeSemaine;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNombresDeSemaines() {
		return NombresDeSemaines;
	}
	public void setNombresDeSemaines(Long nombresDeSemaines) {
		NombresDeSemaines = nombresDeSemaines;
	}
	public String getPeriodeSemaine() {
		return periodeSemaine;
	}
	public void setPeriodeSemaine(String periodeSemaine) {
		this.periodeSemaine = periodeSemaine;
	}
	
	
	
}
