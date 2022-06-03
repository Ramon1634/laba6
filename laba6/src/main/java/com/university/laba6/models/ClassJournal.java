package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class ClassJournal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Valid
    @OneToOne
    private Attendance attendance;

    @Valid
    @OneToOne(mappedBy = "classJournal")
    private Class aClass;

    public ClassJournal() {
    }

    public ClassJournal(Attendance attendance, Class aClass) {
        this.attendance = attendance;
        this.aClass = aClass;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
