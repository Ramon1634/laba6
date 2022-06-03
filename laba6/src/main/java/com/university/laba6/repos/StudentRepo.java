package com.university.laba6.repos;

import com.university.laba6.models.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    List<Student> findBySurnameAndFirstNameAndMiddleName(String surname, String firstName, String MiddleName);
}
