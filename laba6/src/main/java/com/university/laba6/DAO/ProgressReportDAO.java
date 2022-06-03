package com.university.laba6.DAO;

import com.university.laba6.Forms.FormProgressReport;
import com.university.laba6.models.Discipline;
import com.university.laba6.models.ProgressReport;
import com.university.laba6.repos.DisciplineRepo;
import com.university.laba6.repos.ProgressReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProgressReportDAO {

    private final ProgressReportRepo progressReportRepo;
    private final DisciplineRepo disciplineRepo;

    @Autowired
    public ProgressReportDAO(ProgressReportRepo progressReportRepo, DisciplineRepo disciplineRepo) {
        this.progressReportRepo = progressReportRepo;
        this.disciplineRepo = disciplineRepo;
    }

    public Iterable<ProgressReport> index() {
        return progressReportRepo.findAll();
    }

    public void save(FormProgressReport formProgressReport) {
        List<Discipline> disciplines = disciplineRepo.findDisciplineByName(formProgressReport.getNameDiscipline());

        ProgressReport progressReport = new ProgressReport();
        progressReport.setDiscipline(disciplines.get(0));
        progressReport.setRate(formProgressReport.getRate());

        progressReportRepo.save(progressReport);
    }

    public void update(int id, ProgressReport updatedProgressReport) {
        ProgressReport progressReport = progressReportRepo.findById(id).orElse(null);

        if (progressReport == null) return;

        progressReport.setRate(updatedProgressReport.getRate());

        progressReportRepo.save(progressReport);
    }

    public ProgressReport show(int id) {
        return progressReportRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        progressReportRepo.deleteById(id);
    }
}
