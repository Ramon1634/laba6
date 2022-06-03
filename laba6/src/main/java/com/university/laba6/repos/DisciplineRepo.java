package com.university.laba6.repos;

import com.university.laba6.models.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineRepo extends CrudRepository<Discipline, Integer> {
    List<Discipline> findDisciplineByName(String name);
}
