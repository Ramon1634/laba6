package com.university.laba6.Forms;

public class FormSchedule {

    private String time;
    private String date;
    private String nameDiscipline;

    public FormSchedule() {
    }

    public FormSchedule(String time, String date, String nameDiscipline) {
        this.time = time;
        this.date = date;
        this.nameDiscipline = nameDiscipline;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }
}
