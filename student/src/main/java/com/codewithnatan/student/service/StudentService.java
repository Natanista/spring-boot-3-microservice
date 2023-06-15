package com.codewithnatan.student.service;

import com.codewithnatan.student.entity.Student;
import com.codewithnatan.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository repository;

    public void saveStudent(Student student){
        repository.save(student);
    }

    public List<Student> findAllStudents(){
        return repository.findAll();
    }

    public List<Student> findAllStudentsBySchool(Integer schoolId) {
       return repository.findAllBySchoolId(schoolId);
    }
}
