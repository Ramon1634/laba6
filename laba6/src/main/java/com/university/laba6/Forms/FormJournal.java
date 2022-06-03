package com.university.laba6.Forms;

public class FormJournal {
    private int numberAttendance;
    private int numberClass;

    public FormJournal() {
    }

    public FormJournal(int numberAttendance, int numberClass) {
        this.numberAttendance = numberAttendance;
        this.numberClass = numberClass;
    }

    public int getNumberAttendance() {
        return numberAttendance;
    }

    public void setNumberAttendance(int numberAttendance) {
        this.numberAttendance = numberAttendance;
    }

    public int getNumberClass() {
        return numberClass;
    }

    public void setNumberClass(int numberClass) {
        this.numberClass = numberClass;
    }
}
