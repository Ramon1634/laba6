package com.university.laba6.DAO;

import com.university.laba6.Forms.FormAttendance;
import com.university.laba6.models.Attendance;
import com.university.laba6.models.Student;
import com.university.laba6.repos.AttendanceRepo;
import com.university.laba6.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttendanceDAO {

    private final AttendanceRepo attendanceRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public AttendanceDAO(AttendanceRepo attendanceRepo, StudentRepo studentRepo) {
        this.attendanceRepo = attendanceRepo;
        this.studentRepo = studentRepo;
    }

    public Iterable<Attendance> index() {
        return attendanceRepo.findAll();
    }

    public void save(FormAttendance formAttendance) {
        List<Student> students = studentRepo.findBySurnameAndFirstNameAndMiddleName(
                formAttendance.getSurnameStudent(),
                formAttendance.getNameStudent(),
                formAttendance.getMiddleNameStudent()
        );

        Attendance attendance = new Attendance();
        attendance.setAttend(formAttendance.getAttendance());
        attendance.setStudent(students.get(0));

        attendanceRepo.save(attendance);
    }

    public void update(int id, Attendance updatedAttendance) {
        Attendance attendance = attendanceRepo.findById(id).orElse(null);

        if (attendance == null) return;

        attendance.setAttend(updatedAttendance.getAttend());

        attendanceRepo.save(attendance);
    }

    public Attendance show(int id) {
        return attendanceRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        attendanceRepo.deleteById(id);
    }
}
