package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 5, max = 25, message = "Name should be between 5 and 25 symbols")
    @NotEmpty(message = "Enter name discipline")
    private String name;

    @Min(value = 0, message = "Hours should be greater 0")
    @NotEmpty(message = "Enter hours")
    private int hours;

    @OneToMany(mappedBy = "discipline")
    private List<Schedule> schedules;

    @OneToMany(mappedBy = "discipline")
    private List<ProgressReport> progressReport;

    @ManyToMany(mappedBy = "disciplines")
    private List<Teacher> teachers;

    public Discipline() {
    }

    public Discipline(String name, int hours, List<Schedule> schedules, List<ProgressReport> progressReport,
                      List<Teacher> teachers) {
        this.name = name;
        this.hours = hours;
        this.schedules = schedules;
        this.progressReport = progressReport;
        this.teachers = teachers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<Schedule> schedules) {
        this.schedules = schedules;
    }

    public List<ProgressReport> getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(List<ProgressReport> progressReport) {
        this.progressReport = progressReport;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }
}
