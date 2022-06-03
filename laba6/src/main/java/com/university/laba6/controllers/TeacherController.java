package com.university.laba6.controllers;

import com.university.laba6.DAO.TeacherDAO;
import com.university.laba6.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController {


    private final TeacherDAO teacherDAO;

    @Autowired
    public TeacherController(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    @GetMapping
    public String getTeachers(Model model) {
        Iterable<Teacher> teachers = teacherDAO.index();
        model.addAttribute("teachers", teachers);
        return "teacher/index";
    }

    @GetMapping("/new")
    public String newTeacher(@ModelAttribute("teacher") Teacher teacher) {
        return "teacher/new";
    }

    @PostMapping
    public String createTeacher(@ModelAttribute("teacher") @Valid Teacher teacher, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "teacher/new";

        teacherDAO.save(teacher);
        return "redirect:/teacher";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", teacherDAO.show(id));
        return "teacher/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("teacher", teacherDAO.show(id));
        return "teacher/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("teacher") @Valid Teacher teacher, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "teacher/edit";

        teacherDAO.update(id, teacher);
        return "redirect:/teacher";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        teacherDAO.delete(id);
        return "redirect:/teacher";
    }
}
