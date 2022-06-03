package com.university.laba6.repos;

import com.university.laba6.models.Attendance;
import org.springframework.data.repository.CrudRepository;

public interface AttendanceRepo extends CrudRepository<Attendance, Integer> {
}
