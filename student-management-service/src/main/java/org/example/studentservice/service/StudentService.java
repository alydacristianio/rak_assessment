package org.example.studentservice.service;

import org.example.studentservice.dto.StudentDTO;
import org.example.studentservice.entity.Student;
import org.example.studentservice.exception.StudentNotFoundException;
import org.example.studentservice.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service layer for Student operations.
 */
@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student addStudent(StudentDTO dto) {
        Student student = new Student();
        student.setStudentName(dto.getStudentName());
        student.setGrade(dto.getGrade());
        student.setMobileNumber(dto.getMobileNumber());
        student.setSchoolName(dto.getSchoolName());
        return repository.save(student);
    }

    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}