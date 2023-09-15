package com.baar.grapghqldemo.service;

import com.baar.grapghqldemo.dto.StudentDto;
import com.baar.grapghqldemo.dto.StudentDtoInput;
import com.baar.grapghqldemo.model.Student;

import java.util.List;

public interface StudentService {

    public List<StudentDto> students();

    public StudentDto student(Integer studentId) throws Exception;

    public Student register(StudentDtoInput dto) throws Exception;

    public   Student updateStudent( Integer studentId,  String address) throws Exception;

    public Student deleteStudent(Integer studentId) throws Exception;
}
