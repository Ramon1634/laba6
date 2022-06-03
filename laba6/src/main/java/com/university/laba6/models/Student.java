package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "Enter name")
    @Size(min = 2, max = 32, message = "Name should be between 2 and 32 symbols")
    private String firstName;

    @NotEmpty(message = "Enter surname")
    @Size(min = 2, max = 32, message = "Surname should be between 2 and 32 symbols")
    private String surname;

    @NotEmpty(message = "Enter middle name")
    @Size(min = 2, max = 32, message = "Middle name should be between 2 and 32 symbols")
    private String middleName;

    @NotEmpty(message = "Enter age")
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;

    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "class_for_student",
        joinColumns =
                { @JoinColumn(name = "student_id", referencedColumnName = "id") },
        inverseJoinColumns =
                { @JoinColumn(name = "class_id", referencedColumnName = "id") })
    private Class classForStudent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "report_for_student",
        joinColumns =
                { @JoinColumn(name = "student_id", referencedColumnName = "id") },
        inverseJoinColumns =
                { @JoinColumn(name = "report_id", referencedColumnName = "id") })
    private ProgressReport progressReport;

    @OneToMany(mappedBy = "student")
    private List<Attendance> attendances;

    public Student() {
    }

    public Student(String firstName, String surname, String middleName, int age, String address, Class classForStudent,
                   ProgressReport progressReport, List<Attendance> attendances) {
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.address = address;
        this.classForStudent = classForStudent;
        this.progressReport = progressReport;
        this.attendances = attendances;
    }

    public Student(String firstName, String surname, String middleName, int age, String address) {
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public Class getClassForStudent() {
        return classForStudent;
    }

    public void setClassForStudent(Class classForStudent) {
        this.classForStudent = classForStudent;
    }

    public ProgressReport getProgressReport() {
        return progressReport;
    }

    public void setProgressReport(ProgressReport progressReport) {
        this.progressReport = progressReport;
    }
}