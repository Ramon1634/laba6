package com.university.laba6.controllers;

import com.university.laba6.DAO.DisciplineDAO;
import com.university.laba6.models.Discipline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/discipline")
public class DisciplineController {

    private final DisciplineDAO disciplineDAO;

    @Autowired
    public DisciplineController(DisciplineDAO disciplineDAO) {
        this.disciplineDAO = disciplineDAO;
    }

    @GetMapping
    public String getDisciplines(Model model) {
        Iterable<Discipline> disciplines = disciplineDAO.index();
        model.addAttribute("disciplines", disciplines);
        return "discipline/index";
    }

    @GetMapping("/new")
    public String newDiscipline(@ModelAttribute("discipline") Discipline discipline) {
        return "discipline/new";
    }

    @PostMapping
    public String createDiscipline(@ModelAttribute("discipline") @Valid Discipline discipline, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "discipline/new";

        disciplineDAO.save(discipline);
        return "redirect:/discipline";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("discipline", disciplineDAO.show(id));
        return "discipline/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("discipline", disciplineDAO.show(id));
        return "discipline/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("discipline") @Valid Discipline discipline, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "discipline/edit";

        disciplineDAO.update(id, discipline);
        return "redirect:/discipline";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        disciplineDAO.delete(id);
        return "redirect:/discipline";
    }

}
