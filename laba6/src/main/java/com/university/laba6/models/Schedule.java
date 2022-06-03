package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Size(min = 1, max = 15, message = "Name should be between 1 and 15 symbols")
    @NotEmpty(message = "Enter name discipline")
    private String time;

    @Valid
    @ManyToOne
    private Discipline discipline;

    @Size(min = 5, max = 25, message = "Name should be between 5 and 25 symbols")
    @NotEmpty(message = "Enter name discipline")
    private String date;

    public Schedule() {
    }

    public Schedule(String time, Discipline discipline, String date) {
        this.time = time;
        this.discipline = discipline;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
