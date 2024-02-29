package com.etensionChrome.etensionChrome.repository;

import com.etensionChrome.etensionChrome.Entity.QuotidienneConfigEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuotidienneConfigRepository extends JpaRepository<QuotidienneConfigEntity,Long> {
}
