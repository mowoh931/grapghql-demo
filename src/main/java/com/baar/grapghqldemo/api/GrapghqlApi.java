package com.baar.grapghqldemo.api;

import com.baar.grapghqldemo.dto.StudentDto;
import com.baar.grapghqldemo.dto.StudentDtoInput;
import com.baar.grapghqldemo.model.Student;
import com.baar.grapghqldemo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/graphql")
public class GrapghqlApi {

    @Autowired
    StudentServiceImpl service;

    @QueryMapping(name = "students")
    public List<StudentDto> students() {
        return service.students();
    }

    @QueryMapping(name = "student")
    public StudentDto student(@Argument Integer studentId) throws Exception {
        return service.student(studentId);
    }

    @MutationMapping
    public Student register(@Argument(name = "input") StudentDtoInput dto) throws Exception {
        return service.register(dto);
    }

    @MutationMapping
    public Student updateStudent(@Argument Integer studentId, @Argument String address) throws Exception {
        return service.updateStudent(studentId, address);
    }

    @MutationMapping
    public Student deleteStudent(@Argument Integer studentId) throws Exception {
        return service.deleteStudent(studentId);
    }
}
