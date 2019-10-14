package cs425.lab8.eregistrar.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "* Student Number is required")
    @Column(nullable = false, unique = true)
    private String studentNumber;

    @NotBlank(message = "* First Name is required")
    @Column(nullable = false, unique = true)
    private String firstName;

    private String middleName;

    @NotBlank(message = "* Last Name is required")
    @Column(nullable = false, unique = true)
    private String lastName;

    private Double cgpa;

    @NotNull(message = "* Enrollment Date is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @NotNull(message = "* 'Is International' is required")
    private int isInternational;

    public Student() {
    }

    public Student(@NotBlank(message = "* Student Number is required") String studentNumber, @NotBlank(message = "* First Name is required") String firstName, String middleName, @NotBlank(message = "* Last Name is required") String lastName, Double cgpa, @NotBlank(message = "* Enrollment Date is required") LocalDate enrollmentDate, @NotBlank(message = "* 'Is International' is required") int isInternational) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
        this.isInternational = isInternational;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }


    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public int getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(int isInternational) {
        this.isInternational = isInternational;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", enrollmentDate=" + enrollmentDate +
                ", isInternational=" + isInternational +
                '}';
    }
}
