package com.student.ms.student.service.impl;

import com.student.ms.student.dao.Student;
import com.student.ms.student.exception.NotFoundException;
import com.student.ms.student.mapper.StudentMapper;
import com.student.ms.student.model.StudentDto;

import com.student.ms.student.repository.StudentRepo;
import com.student.ms.student.service.StudentService;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Page<StudentDto> getStudents(Pageable pageable) {
        return StudentMapper.PageStudentsToPageStudentDtos(studentRepo.findAll(pageable));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.delete(studentRepo.findById(id)
                .orElseThrow(()->new NotFoundException("not-found")));
    }

    @Override
    public void addStudent(StudentDto student) {
        student.setId(null);
        studentRepo.save(StudentMapper.StudentDtoToStudent(student));
    }


    @Override
    public void editStudent(Long id, StudentDto student) {
        Student newStudent = studentRepo.findById(id).orElseThrow(()->new NotFoundException("no-found"));
        newStudent.setName(student.getName());
        newStudent.setBirthday(student.getBirthday());
        studentRepo.save(newStudent);
    }
}
