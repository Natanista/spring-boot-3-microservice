package com.codewithnatan.school.service;

import com.codewithnatan.school.config.StudentClient;
import com.codewithnatan.school.entity.FullSchoolResponse;
import com.codewithnatan.school.entity.School;
import com.codewithnatan.school.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {

    private final SchoolRepository repository;

    @Autowired
    private StudentClient client;

    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        var school = repository.findById(schoolId)
                .orElse(School
                        .builder()
                        .name("NOT A SCHOOL")
                        .email("notaschool@email.com")
                        .build()
                );
        var students = client.findAllStudentsBySchool(schoolId);
        return FullSchoolResponse
                .builder()
                .name(school.getName())
                .email(school.getEmail())
                .students(students)
                .build();
    }
}
