package com.baar.grapghqldemo.api;

import com.baar.grapghqldemo.dto.StudentDto;
import com.baar.grapghqldemo.model.Student;
import com.baar.grapghqldemo.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentApi {


    @Autowired
    StudentServiceImpl service;

    @GetMapping("/all")
    public List<StudentDto> students() {
        return service.students();
    }

    @GetMapping("/one/{studentId}")
    public StudentDto student(@PathVariable Integer studentId) throws Exception {
        return service.student(studentId);
    }

    @DeleteMapping("delete/{studentId}")
    public Student deleteStudent(@PathVariable(value = "studentId") Integer studentId) throws Exception {
        return service.deleteStudent(studentId);
    }


}
