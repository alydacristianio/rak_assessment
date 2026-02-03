package org.example.studentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.studentservice.dto.StudentDTO;
import org.example.studentservice.entity.Student;
import org.example.studentservice.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@Tag(name = "Student APIs", description = "APIs for managing students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @Operation(summary = "Add a new student")
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Student student = service.addStudent(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {
        return service.getStudentById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }
}