package com.etensionChrome.etensionChrome.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class QuotidienneConfigEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ElementCollection
	private List<String> heuresDeLaJournee;

	public QuotidienneConfigEntity() {
		this.heuresDeLaJournee = new ArrayList<>();
		initialiserHeuresDeLaJournee();
	}

	private void initialiserHeuresDeLaJournee() {
		// Ajouter toutes les heures de la journée à la liste
		for (int heure = 0; heure < 24; heure++) {
			for (int minute = 0; minute < 60; minute += 15) {
				String heureMinute = String.format("%02d:%02d", heure, minute);
				heuresDeLaJournee.add(heureMinute);
			}
		}
	}

	public List<String> getHeuresDeLaJournee() {
		return heuresDeLaJournee;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
}
