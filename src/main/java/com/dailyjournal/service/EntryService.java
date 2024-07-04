package com.dailyjournal.service;

import com.dailyjournal.domain.Entry;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntryService {

    List<Entry> getAllEntries();

    Optional<Entry> getEntryById(UUID id);

    Entry saveEntry(Entry entry);

    void deleteEntry(UUID id);

}
