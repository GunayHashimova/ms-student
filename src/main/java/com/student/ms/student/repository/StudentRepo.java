package com.student.ms.student.repository;

import com.student.ms.student.dao.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface StudentRepo extends JpaRepository<Student,Long> {
    List<Student> findStudentByNameContains(String name);
}
