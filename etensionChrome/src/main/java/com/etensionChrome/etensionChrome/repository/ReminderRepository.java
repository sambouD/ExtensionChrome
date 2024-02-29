package com.etensionChrome.etensionChrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etensionChrome.etensionChrome.Entity.Reminder;

@Repository
public interface ReminderRepository extends  JpaRepository<Reminder, Long>{

}
