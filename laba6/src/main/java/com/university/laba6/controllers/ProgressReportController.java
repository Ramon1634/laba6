package com.university.laba6.controllers;

import com.university.laba6.DAO.ProgressReportDAO;
import com.university.laba6.Forms.FormProgressReport;
import com.university.laba6.models.ProgressReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/progressReport")
public class ProgressReportController {

    private final ProgressReportDAO progressReportDAO;

    @Autowired
    public ProgressReportController(ProgressReportDAO progressReportDAO) {
        this.progressReportDAO = progressReportDAO;
    }

    @GetMapping
    public String getProgressReports(Model model) {
        model.addAttribute("progressReports", progressReportDAO.index());
        return "progressReport/index";
    }

    @GetMapping("/new")
    public String newProgressReport(@ModelAttribute("formProgressReport") FormProgressReport FormProgressReport) {
        return "progressReport/new";
    }

    @PostMapping
    public String createProgressReport(@ModelAttribute("formProgressReport") @Valid FormProgressReport formProgressReport, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "progressReport/new";

        progressReportDAO.save(formProgressReport);
        return "redirect:/progressReport";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("progressReport", progressReportDAO.show(id));
        return "progressReport/show";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("progressReport", progressReportDAO.show(id));
        return "progressReport/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("progressReport") @Valid ProgressReport progressReport, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "progressReport/edit";

        progressReportDAO.update(id, progressReport);
        return "redirect:/progressReport";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        progressReportDAO.delete(id);
        return "redirect:/progressReport";
    }

}
