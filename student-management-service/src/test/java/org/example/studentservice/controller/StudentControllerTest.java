package org.example.studentservice.controller;

import org.example.studentservice.dto.StudentDTO;
import org.example.studentservice.entity.Student;
import org.example.studentservice.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentControllerTest {

    private final StudentService service = mock(StudentService.class);
    private final StudentController controller = new StudentController(service);

    @Test
    void testGetAllStudents() {
        when(service.getAllStudents()).thenReturn(List.of(new Student()));
        ResponseEntity<List<Student>> response = controller.getAllStudents();
        assertEquals(1, response.getBody().size());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetStudentById_Found() {
        Student student = new Student();
        student.setStudentName("Alice");
        when(service.getStudentById(1L)).thenReturn(Optional.of(student));
        ResponseEntity<Student> response = controller.getStudent(1L);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Alice", response.getBody().getStudentName());
    }

    @Test
    void testGetStudentById_NotFound() {
        when(service.getStudentById(1L)).thenReturn(Optional.empty());
        ResponseEntity<Student> response = controller.getStudent(1L);
        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }


    @Test
    void testAddStudent() {
        StudentDTO dto = new StudentDTO();
        dto.setStudentName("Bob");
        dto.setGrade("10");
        dto.setMobileNumber("9998887776");
        dto.setSchoolName("Greenwood High");
        Student saved = new Student();
        saved.setStudentName("Bob");
        when(service.addStudent(dto)).thenReturn(saved);
        ResponseEntity<Student> response = controller.addStudent(dto);
        assertEquals(201, response.getStatusCodeValue());
        assertEquals("Bob", response.getBody().getStudentName());
    }
}
