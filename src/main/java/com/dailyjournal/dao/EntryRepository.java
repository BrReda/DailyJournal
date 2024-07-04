package com.dailyjournal.dao;

import com.dailyjournal.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface EntryRepository extends JpaRepository<Entry, UUID> {

    boolean existsByTitle(String title);

}
