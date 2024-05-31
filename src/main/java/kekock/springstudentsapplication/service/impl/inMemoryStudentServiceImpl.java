package kekock.springstudentsapplication.service.impl;

import kekock.springstudentsapplication.entity.Student;
import kekock.springstudentsapplication.repository.inMemoryStudentDAO;
import kekock.springstudentsapplication.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class inMemoryStudentServiceImpl implements StudentService {

    private final inMemoryStudentDAO repository;

    @Override
    public Student saveStudent(Student student) {
        return repository.saveStudent(student);
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(String email) {
        repository.deleteStudent(email);
    }

    @Override
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }
}