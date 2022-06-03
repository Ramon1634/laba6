package com.university.laba6.Forms;

public class FormClass {

    private String name;
    private String surnameTeacher;
    private String firstNameTeacher;
    private String MiddleNameTeacher;
    private int numberJournal;

    public FormClass() {
    }

    public FormClass(String name, String surnameTeacher, String firstNameTeacher, String middleNameTeacher, int numberJournal) {
        this.name = name;
        this.surnameTeacher = surnameTeacher;
        this.firstNameTeacher = firstNameTeacher;
        MiddleNameTeacher = middleNameTeacher;
        this.numberJournal = numberJournal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnameTeacher() {
        return surnameTeacher;
    }

    public void setSurnameTeacher(String surnameTeacher) {
        this.surnameTeacher = surnameTeacher;
    }

    public String getFirstNameTeacher() {
        return firstNameTeacher;
    }

    public void setFirstNameTeacher(String firstNameTeacher) {
        this.firstNameTeacher = firstNameTeacher;
    }

    public String getMiddleNameTeacher() {
        return MiddleNameTeacher;
    }

    public void setMiddleNameTeacher(String middleNameTeacher) {
        MiddleNameTeacher = middleNameTeacher;
    }

    public int getNumberJournal() {
        return numberJournal;
    }

    public void setNumberJournal(int numberJournal) {
        this.numberJournal = numberJournal;
    }
}
