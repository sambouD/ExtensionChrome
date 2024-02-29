package com.etensionChrome.etensionChrome.repository;

import com.etensionChrome.etensionChrome.Entity.HebdomadaireConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HebdomadaireConfigReposiotory extends JpaRepository<HebdomadaireConfigEntity,Long> {
}
