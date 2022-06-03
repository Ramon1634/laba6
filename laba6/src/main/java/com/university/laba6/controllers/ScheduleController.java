package com.university.laba6.controllers;

import com.university.laba6.DAO.ScheduleDAO;
import com.university.laba6.Forms.FormSchedule;
import com.university.laba6.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleDAO scheduleDAO;

    @Autowired
    public ScheduleController(ScheduleDAO scheduleDAO) {
        this.scheduleDAO = scheduleDAO;
    }

    @GetMapping
    public String getSchedules(Model model) {
        Iterable<Schedule> schedules = scheduleDAO.index();
        model.addAttribute("schedules", schedules);
        return "schedule/index";
    }

    @GetMapping("/new")
    public String newAttendance(@ModelAttribute("formSchedule") FormSchedule formSchedule) {
        return "schedule/new";
    }

    @PostMapping
    public String createAttendance(@ModelAttribute("formSchedule") @Valid FormSchedule formSchedule, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "schedule/new";

        scheduleDAO.save(formSchedule);
        return "redirect:/schedule";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("schedule", scheduleDAO.show(id));
        return "schedule/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        Schedule schedule = scheduleDAO.show(id);
        FormSchedule formSchedule = new FormSchedule();
        formSchedule.setTime(schedule.getTime());
        formSchedule.setDate(schedule.getDate());
        formSchedule.setNameDiscipline(schedule.getDiscipline().getName());
        model.addAttribute("formSchedule", formSchedule);
        return "schedule/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("schedule") @Valid Schedule schedule, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "schedule/edit";

        scheduleDAO.update(id, schedule);
        return "redirect:/schedule";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        scheduleDAO.delete(id);
        return "redirect:/schedule";
    }
}
