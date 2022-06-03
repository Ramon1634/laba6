package com.university.laba6.DAO;

import com.university.laba6.Forms.FormJournal;
import com.university.laba6.models.Attendance;
import com.university.laba6.models.ClassJournal;
import com.university.laba6.models.Discipline;
import com.university.laba6.repos.AttendanceRepo;
import com.university.laba6.repos.JournalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalDAO {

    private final JournalRepo journalRepo;
    private final AttendanceRepo attendanceRepo;

    @Autowired
    public JournalDAO(JournalRepo journalRepo, AttendanceRepo attendanceRepo) {
        this.journalRepo = journalRepo;
        this.attendanceRepo = attendanceRepo;
    }

    public Iterable<ClassJournal> index() {
        return journalRepo.findAll();
    }

    public void save(FormJournal formJournal) {
        Attendance attendance = attendanceRepo.findById(formJournal.getNumberAttendance()).orElse(null);

        if (attendance == null) return;

        ClassJournal journal = new ClassJournal();
        journal.setAttendance(attendance);

        journalRepo.save(journal);
    }

    public ClassJournal show(int id) {
        return journalRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        journalRepo.deleteById(id);
    }
}
