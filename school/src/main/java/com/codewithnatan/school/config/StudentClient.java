package com.codewithnatan.school.config;

import com.codewithnatan.school.entity.Student;
import org.hibernate.annotations.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface StudentClient {

    @GetMapping("/school/{schoolId}")
    List<Student> findAllStudentsBySchool(@PathVariable("schoolId") Integer schoolId);

}
