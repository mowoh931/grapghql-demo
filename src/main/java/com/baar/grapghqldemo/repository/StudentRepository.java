package com.baar.grapghqldemo.repository;

import com.baar.grapghqldemo.model.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class StudentRepository {
    private final List<Student> students = new ArrayList<>();

    @PostConstruct
    public void init() {
        students.add(Student.builder()
                .studentId(1)
                .lastname("Foo")
                .firstname("Barney")
                .address("Somewhere")
                .build());
        students.add(Student.builder()
                .studentId(2)
                .lastname("Doe")
                .firstname("John")
                .address("Everywhere")
                .build());
    }


    public Student save(Student student) {
        student = Student.builder()
                .studentId(student.getStudentId())
                .lastname(student.getLastname())
                .firstname(student.getFirstname())
                .address(student.getAddress())
                .build();
        students.add(student);
        return student;
    }


    public List<Student> findAll(
    ) {
        return students;

    }

    public Optional<Student> findById(Integer id) {
        return students.stream()
                .filter(student -> Objects.equals(student.getStudentId(), id))
                .findFirst();
    }

    public Student delete(Integer id) {
        Optional<Student> student = findById(id);
        student.ifPresent(students::remove);
        return student.get();


    }


}

