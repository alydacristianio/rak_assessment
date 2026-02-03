package org.example.studentservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for creating Student
 */
@Data                   // Generates getters, setters, toString, equals & hashCode
@NoArgsConstructor      // Generates no-args constructor
@AllArgsConstructor     // Generates all-args constructor
public class StudentDTO {

    @NotBlank(message = "Student name is mandatory")
    private String studentName;

    @NotBlank(message = "Grade is mandatory")
    private String grade;

    @NotBlank(message = "Mobile number is mandatory")
    private String mobileNumber;

    @NotBlank(message = "School name is mandatory")
    private String schoolName;
}
