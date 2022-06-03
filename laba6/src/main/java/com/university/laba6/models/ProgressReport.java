package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class ProgressReport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    private Discipline discipline;

    @Min(value = 2, message = "Rate should be between 2 and 5")
    @Max(value = 5, message = "Rate should be between 2 and 5")
    private int rate;

    @OneToOne(mappedBy = "progressReport")
    private Student student;

    public ProgressReport() {
    }

    public ProgressReport(Discipline discipline, int rate, Student student) {
        this.discipline = discipline;
        this.rate = rate;
        this.student = student;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
