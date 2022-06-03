package com.university.laba6.repos;

import com.university.laba6.models.Teacher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeacherRepo extends CrudRepository<Teacher, Integer> {
    List<Teacher> findBySurnameAndFirstNameAndMiddleName(String surname, String firstName, String middleName);
}
