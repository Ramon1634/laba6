package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

@Entity
@Table(name = "formed_class")
public class Class {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 5, max = 15, message = "Name should be between  5 and 15 symbols")
    private String name;

    @Valid
    @OneToOne(mappedBy = "classForStudent")
    private Student student;

    @Valid
    @OneToOne
    private ClassJournal classJournal;

    @Valid
    @OneToOne
    private Teacher classroomTeacher;

    public Class() {
    }

    public Class(String name, Student student, ClassJournal classJournal, Teacher classroomTeacher) {
        this.name = name;
        this.student = student;
        this.classJournal = classJournal;
        this.classroomTeacher = classroomTeacher;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClassJournal getClassJournal() {
        return classJournal;
    }

    public void setClassJournal(ClassJournal classJournal) {
        this.classJournal = classJournal;
    }

    public Teacher getClassroomTeacher() {
        return classroomTeacher;
    }

    public void setClassroomTeacher(Teacher classroomTeacher) {
        this.classroomTeacher = classroomTeacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
