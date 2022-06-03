package com.university.laba6.DAO;

import com.university.laba6.models.Discipline;
import com.university.laba6.repos.DisciplineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DisciplineDAO {

    private final DisciplineRepo disciplineRepo;

    @Autowired
    public DisciplineDAO(DisciplineRepo disciplineRepo) {
        this.disciplineRepo = disciplineRepo;
    }

    public Iterable<Discipline> index() {
        return disciplineRepo.findAll();
    }

    public void save(Discipline discipline) {
        disciplineRepo.save(discipline);
    }

    public void update(int id, Discipline updatedDiscipline) {
        Discipline discipline = disciplineRepo.findById(id).orElse(null);

        if (discipline == null) return;

        discipline.setName(updatedDiscipline.getName());
        discipline.setHours(updatedDiscipline.getHours());
        discipline.setProgressReport(updatedDiscipline.getProgressReport());
        discipline.setSchedules(updatedDiscipline.getSchedules());
        discipline.setTeachers(updatedDiscipline.getTeachers());

        disciplineRepo.save(discipline);
    }

    public Discipline show(int id) {
        return disciplineRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        disciplineRepo.deleteById(id);
    }
}
