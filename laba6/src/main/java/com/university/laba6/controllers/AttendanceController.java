package com.university.laba6.controllers;

import com.university.laba6.DAO.AttendanceDAO;
import com.university.laba6.Forms.FormAttendance;
import com.university.laba6.models.Attendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

    private final AttendanceDAO attendanceDAO;

    @Autowired
    public AttendanceController(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
    }

    @GetMapping
    public String getAttendances(Model model) {
        Iterable<Attendance> attendances = attendanceDAO.index();
        model.addAttribute("attendances", attendances);
        return "attendance/index";
    }

    @GetMapping("/new")
    public String newAttendance(@ModelAttribute("formAttendance") FormAttendance helperAttendance) {
        return "attendance/new";
    }

    @PostMapping
    public String createAttendance(@ModelAttribute("formAttendance") @Valid FormAttendance formAttendance, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "attendance/new";

        attendanceDAO.save(formAttendance);
        return "redirect:/attendance";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("attendance", attendanceDAO.show(id));
        return "attendance/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("attendance", attendanceDAO.show(id));
        return "attendance/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("attendance") @Valid Attendance attendance, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "attendance/edit";

        attendanceDAO.update(id, attendance);
        return "redirect:/attendance";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        attendanceDAO.delete(id);
        return "redirect:/attendance";
    }
}
