package com.university.laba6.DAO;

import com.university.laba6.Forms.FormClass;
import com.university.laba6.models.Class;
import com.university.laba6.models.Teacher;
import com.university.laba6.repos.ClassJournalRepo;
import com.university.laba6.repos.FormedClassRepo;
import com.university.laba6.repos.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClassDAO {

    private final FormedClassRepo formedClassRepo;
    private final TeacherRepo teacherRepo;
    private final ClassJournalRepo classJournalRepo;

    @Autowired
    public ClassDAO(FormedClassRepo formedClassRepo, TeacherRepo teacherRepo, ClassJournalRepo classJournalRepo) {
        this.formedClassRepo = formedClassRepo;
        this.teacherRepo = teacherRepo;
        this.classJournalRepo = classJournalRepo;
    }

    public Iterable<Class> index() {
        return formedClassRepo.findAll();
    }

    public void save(FormClass formClass) {
        List<Teacher> teachers = teacherRepo.findBySurnameAndFirstNameAndMiddleName(
                formClass.getSurnameTeacher(),
                formClass.getFirstNameTeacher(),
                formClass.getMiddleNameTeacher()
        );

        Class newClass = new Class();
        newClass.setName(formClass.getName());
        newClass.setClassroomTeacher(teachers.get(0));
        newClass.setClassJournal(classJournalRepo.findById(formClass.getNumberJournal()).orElse(null));

        formedClassRepo.save(newClass);
    }

    public void update(int id, Class updatedClass) {
        Class aClass = formedClassRepo.findById(id).orElse(null);

        if (aClass == null) return;

        aClass.setName(updatedClass.getName());

        formedClassRepo.save(aClass);
    }

    public Class show(int id) {
        return formedClassRepo.findById(id).orElse(null);
    }

    public void delete(int id) {
        formedClassRepo.deleteById(id);
    }
}
