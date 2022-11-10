package domain.student;

import domain.student.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentRepository {

    void register(Student student);

    Student findByCPF(CPF cpf);

    List<Student> findAllStudentsRegistered();

}
