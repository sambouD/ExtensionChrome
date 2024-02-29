package com.etensionChrome.etensionChrome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etensionChrome.etensionChrome.Entity.ScheduledNotification;

public interface ScheduledNotificationRepository extends  JpaRepository<ScheduledNotification, Long> {

}
