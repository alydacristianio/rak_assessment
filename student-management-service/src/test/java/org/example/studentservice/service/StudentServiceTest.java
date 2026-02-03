package org.example.studentservice.service;

import org.example.studentservice.dto.StudentDTO;
import org.example.studentservice.entity.Student;
import org.example.studentservice.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    private final StudentRepository repo = mock(StudentRepository.class);
    private final StudentService service = new StudentService(repo);

    @Test
    void testGetAllStudents() {
        when(repo.findAll()).thenReturn(List.of(new Student(), new Student()));
        List<Student> students = service.getAllStudents();
        assertEquals(2, students.size());
    }

    @Test
    void testGetStudentById() {
        Student student = new Student();
        student.setStudentName("Alice");
        when(repo.findById(1L)).thenReturn(Optional.of(student));
        Optional<Student> result = service.getStudentById(1L);
        assertTrue(result.isPresent());
        assertEquals("Alice", result.get().getStudentName());
    }

    @Test
    void testAddStudent() {
        StudentDTO dto = new StudentDTO();
        dto.setStudentName("Bob");
        dto.setGrade("10");
        dto.setMobileNumber("9998887776");
        dto.setSchoolName("Greenwood High");
        Student savedStudent = new Student();
        savedStudent.setStudentName(dto.getStudentName());
        when(repo.save(any(Student.class))).thenReturn(savedStudent);
        Student result = service.addStudent(dto);
        assertEquals("Bob", result.getStudentName());
        verify(repo, times(1)).save(any(Student.class));
    }
}
