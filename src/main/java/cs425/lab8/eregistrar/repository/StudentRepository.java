package cs425.lab8.eregistrar.repository;

import cs425.lab8.eregistrar.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByStudentNumberContainingIgnoreCase(String studentNumber);
    Optional<Student> findByStudentNumber(String studentNumber);
}
