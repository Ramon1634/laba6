package com.university.laba6.repos;

import com.university.laba6.models.ClassJournal;
import org.springframework.data.repository.CrudRepository;

public interface JournalRepo extends CrudRepository<ClassJournal, Integer> {
}
