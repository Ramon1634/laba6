package com.university.laba6.controllers;

import com.university.laba6.DAO.ClassDAO;
import com.university.laba6.Forms.FormClass;
import com.university.laba6.models.Class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/class")
public class ClassController {

    private final ClassDAO classDAO;

    @Autowired
    public ClassController(ClassDAO classDAO) {
        this.classDAO = classDAO;
    }

    @GetMapping
    public String getClasses(Model model) {
        Iterable<Class> classes = classDAO.index();
        model.addAttribute("classes", classes);
        return "class/index";
    }

    @GetMapping("/new")
    public String newClass(@ModelAttribute("formClass") FormClass formClass) {
        return "class/new";
    }

    @PostMapping
    public String createClass(@ModelAttribute("formClass") @Valid FormClass formClass, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "class/new";

        classDAO.save(formClass);
        return "redirect:/class";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("class", classDAO.show(id));
        return "class/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("class", classDAO.show(id));
        return "class/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("class") @Valid Class updatedClass, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "class/edit";

        classDAO.update(id, updatedClass);
        return "redirect:/class";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        classDAO.delete(id);
        return "redirect:/class";
    }
}
