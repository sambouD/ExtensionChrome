package com.etensionChrome.etensionChrome.repository;

import com.etensionChrome.etensionChrome.Entity.PeriodiciteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodiciteRepository extends JpaRepository<PeriodiciteEntity,Long> {
}
