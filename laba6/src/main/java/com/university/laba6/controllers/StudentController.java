package com.university.laba6.controllers;

import com.university.laba6.DAO.StudentDAO;
import com.university.laba6.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentDAO studentDAO;

    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping
    public String getStudents(Model model) {
        Iterable<Student> students = studentDAO.index();
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/new")
    public String newStudent(@ModelAttribute("student") Student student) {
        return "student/new";
    }

    @PostMapping
    public String createStudent(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "student/new";

        studentDAO.save(student);
        return "redirect:/student";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("student", studentDAO.show(id));
        return "student/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentDAO.show(id));
        return "student/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("student") @Valid Student student, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "student/edit";

        studentDAO.update(id, student);
        return "redirect:/student";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        studentDAO.delete(id);
        return "redirect:/student";
    }
}
