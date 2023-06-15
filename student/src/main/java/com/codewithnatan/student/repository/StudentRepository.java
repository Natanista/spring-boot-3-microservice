package com.codewithnatan.student.repository;

import com.codewithnatan.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllBySchoolId(Integer schoolId);
}
