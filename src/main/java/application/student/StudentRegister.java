package application.student;

import domain.student.StudentRepository;
import domain.student.exceptions.CPFException;
import domain.student.exceptions.EmailException;

public class StudentRegister {

    private final StudentRepository studentRepository;

    public StudentRegister(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void execute(StudentRegisterDto data) throws EmailException, CPFException {
        var student = data.createStudent();
        studentRepository.register(student);
    }
}
