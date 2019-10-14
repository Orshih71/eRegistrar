package cs425.lab8.eregistrar.service.impl;

import cs425.lab8.eregistrar.model.Student;
import cs425.lab8.eregistrar.repository.StudentRepository;
import cs425.lab8.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public Iterable<Student> getAllStudents() {
        return repository.findAll(Sort.by("firstName"));
    }

    @Override
    public Page<Student> getAllStudentsPaged(int pageNo) {
        return repository.findAll(PageRequest.of(pageNo, 3, Sort.by("firstName")));
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getStudentById(Integer studentId) {
        return repository.findById(studentId).orElse(null);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        repository.deleteById(studentId);
    }

    @Override
    public Optional<Student> findByStudentNumber(String studentNumber) {
        return repository.findByStudentNumber(studentNumber);
    }
    @Override
    public List<Student> findByStudentNumberContains(String studentNumber) {
        return repository.findByStudentNumberContainingIgnoreCase(studentNumber);
    }

}
