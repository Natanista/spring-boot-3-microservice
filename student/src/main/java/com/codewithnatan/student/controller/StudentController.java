package com.codewithnatan.student.controller;

import com.codewithnatan.student.entity.Student;
import com.codewithnatan.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        service.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return ResponseEntity.ok(service.findAllStudents());
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getStudents(
            @PathVariable("schoolId") Integer schoolId
    ){
        return ResponseEntity.ok(service.findAllStudentsBySchool(schoolId));
    }

}
