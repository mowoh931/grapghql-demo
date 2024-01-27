package com.baar.grapghqldemo.service;

import com.baar.grapghqldemo.dto.StudentDto;
import com.baar.grapghqldemo.dto.StudentDtoInput;
import com.baar.grapghqldemo.model.Student;
import com.baar.grapghqldemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository repository;

    public List<StudentDto> students() {
        return repository.findAll().stream()
                .map(student -> StudentDto.builder()
                        .studentId(student.getStudentId())
                        .lastname(student.getLastname())
                        .firstname(student.getFirstname())
                        .address(student.getAddress())
                        .build()).toList();
    }

    @Override
    public StudentDto student(Integer studentId) throws Exception {
        return repository.findById(studentId)
                .map(student -> StudentDto.builder()
                        .studentId(student.getStudentId())
                        .lastname(student.getLastname())
                        .firstname(student.getFirstname())
                        .address(student.getAddress())
                        .build())
                .orElseThrow(() -> new Exception("Could not find student"));
    }

    @Override
    public Student register(StudentDtoInput dto) throws Exception {
        Optional<Student> optional = repository.findById(dto.getStudentId());
        if (optional.isPresent()) {
            throw new Exception("Student already registered");
        }
        Student student = new Student(dto.getStudentId()
                , dto.getLastname(), dto.getFirstname(), dto.getAddress());
        repository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Integer studentId, String address) throws Exception {
        return repository.save(
                repository.findById(studentId).map(student -> Student.builder()
                                .studentId(student.getStudentId())
                                .lastname(student.getLastname())
                                .firstname(student.getFirstname())
                                .address(address)
                                .build())
                        .orElseThrow(() -> new Exception("Could not find student"))
        );

    }

    @Override
    public Student deleteStudent(Integer studentId) throws Exception {
        Student student = repository.findById(studentId)
                .orElseThrow(() -> new Exception("Could not find student"));
        repository.delete(studentId);
        return student;

    }
}
