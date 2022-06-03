package com.university.laba6.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Teacher {

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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "disciplines",
            joinColumns =
                    { @JoinColumn(name = "teacher_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "discipline_id", referencedColumnName = "id") })
    private List<Discipline> disciplines;

    @OneToOne(mappedBy = "classroomTeacher")
    private Class aClass;

    public Teacher() {
    }

    public Teacher(String firstName, String surname, String middleName, int age, List<Discipline> disciplines,
                   Class aClass) {
        this.firstName = firstName;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.disciplines = disciplines;
        this.aClass = aClass;
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

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public void setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
    }

    public Class getFormedClass() {
        return aClass;
    }

    public void setFormedClass(Class aClass) {
        this.aClass = aClass;
    }
}