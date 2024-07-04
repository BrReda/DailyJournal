package com.dailyjournal.config;

import com.dailyjournal.dao.EntryRepository;
import com.dailyjournal.domain.Entry;
import com.dailyjournal.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class DataInitializerTask {

    private final EntryService service;
    private final EntryRepository repository;


    public void initialize() {
        // Init Packages if not existing
         initEntries();
    }

    private void initEntries() {
        Stream.of(getEntry(), getSecondEntry())
                .filter(Predicate.not(entry -> repository.existsByTitle(entry.getTitle())))
                .forEach(service::saveEntry);
    }

    private static Entry getEntry() {
         return Entry.builder()
                .title("First Entry")
                .content("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit" +
                " in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat" +
                " non proident, sunt in culpa qui officia deserunt mollit anim id est laborum")
                .tags(Arrays.asList("first", "happy"))
                .build();
    }

    private static Entry getSecondEntry() {
        return Entry.builder()
                .title("Second Entry")
                .content(" ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation " +
                "ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit")
                .tags(Arrays.asList("second", "thoughtful"))
                .build();
    }


}
