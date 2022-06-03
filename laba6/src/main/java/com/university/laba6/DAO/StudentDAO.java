package com.university.laba6.DAO;

import com.university.laba6.models.Student;
import com.university.laba6.repos.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDAO {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentDAO(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public Iterable<Student> index() {
        return studentRepo.findAll();
    }

    public void save(Student student) {
        studentRepo.save(student);
    }

    public void update(int id, Student updatedStudent) {
        Student student = studentRepo.findById(id).orElse(null);

        if (student == null) return;

        student.setSurname(updatedStudent.getSurname());
        student.setFirstName(updatedStudent.getFirstName());
        student.setMiddleName(updatedStudent.getMiddleName());
        student.setAge(updatedStudent.getAge());
        student.setAddress(updatedStudent.getAddress());
        student.setAttendances(updatedStudent.getAttendances());
        student.setProgressReport(updatedStudent.getProgressReport());
        student.setClassForStudent(updatedStudent.getClassForStudent());

        studentRepo.save(student);
    }

    public Student show(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        studentRepo.deleteById(id);
    }
}
