package com.student.ms.student.service;

import com.student.ms.student.model.StudentDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StudentService {
    Page<StudentDto> getStudents(Pageable pageable);

    void deleteStudent(Long id);

    void addStudent(StudentDto student);

    void editStudent(Long id, StudentDto student);
}
