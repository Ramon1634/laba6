package com.university.laba6.Forms;

public class FormAttendance {

    private String nameStudent;
    private String surnameStudent;
    private String middleNameStudent;
    private String attendance;

    public FormAttendance() {
    }

    public FormAttendance(String nameStudent, String surnameStudent, String middleNameStudent, String attendance) {
        this.nameStudent = nameStudent;
        this.surnameStudent = surnameStudent;
        this.middleNameStudent = middleNameStudent;
        this.attendance = attendance;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent) {
        this.surnameStudent = surnameStudent;
    }

    public String getMiddleNameStudent() {
        return middleNameStudent;
    }

    public void setMiddleNameStudent(String middleNameStudent) {
        this.middleNameStudent = middleNameStudent;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }
}
