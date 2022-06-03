package com.university.laba6.controllers;

import com.university.laba6.DAO.JournalDAO;
import com.university.laba6.Forms.FormClass;
import com.university.laba6.Forms.FormJournal;
import com.university.laba6.models.Class;
import com.university.laba6.models.ClassJournal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/journal")
public class JournalController {
    private final JournalDAO journalDAO;

    @Autowired
    public JournalController(JournalDAO journalDAO) {
        this.journalDAO = journalDAO;
    }

    @GetMapping
    public String getJournals(Model model) {
        Iterable<ClassJournal> journals = journalDAO.index();
        model.addAttribute("journals", journals);
        return "journal/index";
    }

    @GetMapping("/new")
    public String newJournal(@ModelAttribute("formJournal") FormJournal formJournal) {
        return "journal/new";
    }

    @PostMapping
    public String createJournal(@ModelAttribute("formJournal") @Valid FormJournal formJournal, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "journal/new";

        journalDAO.save(formJournal);
        return "redirect:/journal";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("journal", journalDAO.show(id));
        return "journal/show";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        journalDAO.delete(id);
        return "redirect:/journal";
    }
}
