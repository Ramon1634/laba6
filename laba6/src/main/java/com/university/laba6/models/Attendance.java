package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Valid
    @ManyToOne
    private Student student;

    @Size(min = 1, max = 15, message = "Attendance should be between 1 and 15 symbols")
    @NotEmpty(message = "Enter attendance")
    private String attend;

    @OneToOne(mappedBy = "attendance")
    private ClassJournal classJournal;

    public Attendance() {
    }

    public Attendance(Student student, String attend, ClassJournal classJournal) {
        this.student = student;
        this.attend = attend;
        this.classJournal = classJournal;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getAttend() {
        return attend;
    }

    public void setAttend(String attend) {
        this.attend = attend;
    }
}
