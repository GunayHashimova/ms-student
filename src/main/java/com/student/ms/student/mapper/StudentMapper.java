package com.student.ms.student.mapper;

import com.student.ms.student.dao.Student;
import com.student.ms.student.model.StudentDto;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class StudentMapper {
    private StudentMapper() {
    }

    public static StudentDto StudentToStudentDto(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .name(student.getName())
                .birthday(student.getBirthday()).build();
    }

    public static Student StudentDtoToStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .name(studentDto.getName())
                .birthday(studentDto.getBirthday()).build();
    }

    public static List<StudentDto> StudentsToStudentDtos(Iterable<Student> students) {
        return StreamSupport.stream(students.spliterator(), false)
                .map(StudentMapper::StudentToStudentDto)
                .collect(Collectors.toList());
    }

    public static List<Student> StudentDtosToStudents(Iterable<StudentDto> studentDtos) {
        return StreamSupport.stream(studentDtos.spliterator(), false)
                .map(StudentMapper::StudentDtoToStudent)
                .collect(Collectors.toList());
    }

    public static Page<StudentDto> PageStudentsToPageStudentDtos(Page<Student> page){
        return page.map(StudentMapper::StudentToStudentDto);
    }

    public static Page<Student> PageStudentDtosToPageStudents(Page<StudentDto> page){
        return page.map(StudentMapper::StudentDtoToStudent);
    }
}
