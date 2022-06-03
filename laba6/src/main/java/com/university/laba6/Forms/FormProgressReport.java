package com.university.laba6.Forms;

public class FormProgressReport {

    private int rate;
    private String nameDiscipline;

    public FormProgressReport() {
    }

    public FormProgressReport(int rate, String nameDiscipline) {
        this.rate = rate;
        this.nameDiscipline = nameDiscipline;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }
}
