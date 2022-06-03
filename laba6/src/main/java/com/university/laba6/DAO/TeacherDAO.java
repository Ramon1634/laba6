package com.university.laba6.DAO;

import com.university.laba6.models.Teacher;
import com.university.laba6.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TeacherDAO {

    private final TeacherRepo teacherRepo;

    @Autowired
    public TeacherDAO(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public Iterable<Teacher> index() {
        return teacherRepo.findAll();
    }

    public void save(Teacher teacher) {
        teacherRepo.save(teacher);
    }

    public void update(int id, Teacher updatedTeacher) {
        Teacher teacher = teacherRepo.findById(id).orElse(null);

        if (teacher == null) return;

        teacher.setSurname(updatedTeacher.getSurname());
        teacher.setFirstName(updatedTeacher.getFirstName());
        teacher.setMiddleName(updatedTeacher.getMiddleName());
        teacher.setAge(updatedTeacher.getAge());
        teacher.setDisciplines(updatedTeacher.getDisciplines());
        teacher.setFormedClass(updatedTeacher.getFormedClass());

        teacherRepo.save(teacher);
    }

    public Teacher show(int id) {
        return teacherRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        teacherRepo.deleteById(id);
    }
}
