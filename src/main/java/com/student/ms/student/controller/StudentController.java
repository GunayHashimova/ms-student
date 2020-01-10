package com.student.ms.student.controller;

import com.student.ms.student.model.StudentDto;
import com.student.ms.student.service.StudentService;
import com.student.ms.student.service.impl.StudentServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Page<StudentDto> getStudents(Pageable pageable){
        return studentService.getStudents(pageable);
    }

    @PostMapping
    public void addStudent(@RequestBody StudentDto student) {
        studentService.addStudent(student);
    }

    @DeleteMapping("{id}")
    public void deleteStudent(@PathVariable Long id){
       studentService.deleteStudent(id);
    }


    @PutMapping("{id}")
    public void editStudent(@PathVariable Long id,@RequestBody StudentDto student){
        studentService.editStudent(id,student);
    }
}
