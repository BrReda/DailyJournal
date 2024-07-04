package com.dailyjournal.controller;

import com.dailyjournal.domain.Entry;
import com.dailyjournal.service.EntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class EntryController {

    private final EntryService service;

    @GetMapping
    public String getAllEntries(Model model) {
        model.addAttribute("entries", service.getAllEntries());
        return "list";
    }

    @GetMapping("/new")
    public String createEntryForm(Model model) {
        model.addAttribute("entry", new Entry());
        return "form";
    }

    @PostMapping
    public String saveEntry(@ModelAttribute Entry entry, @RequestParam String tags) {
        List<String> tagList = Arrays.stream(tags.split(","))
                .map(String::trim)
                .toList();
        entry.setTags(tagList);
        service.saveEntry(entry);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editEntryForm(@PathVariable UUID id, Model model) {
        model.addAttribute("entry", service.getEntryById(id).orElse(new Entry()));
        return "form";
    }

    @PostMapping("/edit/{id}")
    public String updateEntry(@PathVariable UUID id, @ModelAttribute Entry entry, @RequestParam String tags) {
        List<String> tagList = Arrays.stream(tags.split(","))
                .map(String::trim)
                .toList();
        entry.setTags(tagList);
        entry.setId(id);
        service.saveEntry(entry);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteEntry(@PathVariable UUID id) {
        service.deleteEntry(id);
        return "redirect:/";
    }

}
