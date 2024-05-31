package kekock.springstudentsapplication.repository;

import kekock.springstudentsapplication.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class inMemoryStudentDAO {
    private final List<Student> Students = new ArrayList<>();

    public Student saveStudent(Student student) {
        Students.add(student);
        return student;
    }

    public Student findByEmail(String email) {
        return Students.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst().orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, Students.size())
                .filter(index -> Students.get(index).getEmail().equals(student.getEmail()))
                .findFirst().orElse(-1);
        if (studentIndex > -1) {
            Students.set(studentIndex, student);
            return student;
        }
        return null;
    }

    public void deleteStudent(String email) {
        var student = findByEmail(email);
        if (student != null) {
            Students.remove(student);
        }
    }

    public List<Student> findAllStudents() {
        return Students;
    }
}