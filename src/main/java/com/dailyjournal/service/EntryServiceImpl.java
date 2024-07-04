package com.dailyjournal.service;

import com.dailyjournal.dao.EntryRepository;
import com.dailyjournal.domain.Entry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EntryServiceImpl implements EntryService{

    private final EntryRepository repository;

    @Override
    public List<Entry> getAllEntries() {
        return repository.findAll();
    }

    @Override
    public Optional<Entry> getEntryById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Entry saveEntry(Entry entry) {
        return repository.save(entry);
    }

    @Override
    public void deleteEntry(UUID id) {
        repository.deleteById(id);
    }

}
