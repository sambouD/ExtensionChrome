package com.etensionChrome.etensionChrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etensionChrome.etensionChrome.Entity.AlerteCraConfig;

@Repository
public interface AlertRepository extends  JpaRepository<AlerteCraConfig, Long>{
	

	
}
