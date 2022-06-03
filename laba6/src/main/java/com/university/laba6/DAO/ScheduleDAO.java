package com.university.laba6.DAO;

import com.university.laba6.Forms.FormSchedule;
import com.university.laba6.models.Discipline;
import com.university.laba6.models.Schedule;
import com.university.laba6.repos.DisciplineRepo;
import com.university.laba6.repos.ScheduleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleDAO {

    private final ScheduleRepo scheduleRepo;
    private final DisciplineRepo disciplineRepo;

    @Autowired
    public ScheduleDAO(ScheduleRepo scheduleRepo, DisciplineRepo disciplineRepo) {
        this.scheduleRepo = scheduleRepo;
        this.disciplineRepo = disciplineRepo;
    }

    public Iterable<Schedule> index() {
        return scheduleRepo.findAll();
    }

    public void save(FormSchedule formSchedule) {
        List<Discipline> disciplines = disciplineRepo.findDisciplineByName(formSchedule.getNameDiscipline());

        Schedule schedule = new Schedule();
        schedule.setDiscipline(disciplines.get(0));
        schedule.setDate(formSchedule.getDate());
        schedule.setTime(formSchedule.getTime());

        scheduleRepo.save(schedule);
    }

    public void update(int id, Schedule updatedSchedule) {
        Schedule schedule = scheduleRepo.findById(id).orElse(null);

        if (schedule == null) return;

        schedule.setTime(updatedSchedule.getTime());
        schedule.setDiscipline(updatedSchedule.getDiscipline());
        schedule.setDate(updatedSchedule.getDate());

        scheduleRepo.save(schedule);
    }

    public Schedule show(int id) {
        return scheduleRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        scheduleRepo.deleteById(id);
    }
}
