package com.codewithnatan.school.controller;

import com.codewithnatan.school.entity.FullSchoolResponse;
import com.codewithnatan.school.entity.School;
import com.codewithnatan.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody School school){
        service.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getStudents(){
        return ResponseEntity.ok(service.findAllSchools());
    }

    @GetMapping(("/students/{schoolId}"))
    public ResponseEntity<FullSchoolResponse> findAllSchools(
            @PathVariable("schoolId") Integer schoolId
    ){
        return ResponseEntity.ok(service.findSchoolWithStudents(schoolId));
    }

}
