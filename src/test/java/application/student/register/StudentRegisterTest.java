package application.student.register;

import domain.student.CPF;
import domain.student.StudentRepository;
import domain.student.exceptions.CPFException;
import domain.student.exceptions.EmailException;
import infrastructure.student.StudentRepositoryInMemory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentRegisterTest {

    private StudentRegister useCaseStudentRegister;
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        studentRepository = new StudentRepositoryInMemory();
        useCaseStudentRegister = new StudentRegister(studentRepository);
    }

    @Test
    void shouldRegisterStudent() throws EmailException, CPFException {

        var name = "John doe";
        var cpf = "01234567890";
        var email = "johndoe@gmail.com";

        var sut = new StudentRegisterDto(name, cpf, email);
        useCaseStudentRegister.execute(sut);

        var studentCreted = studentRepository.findByCPF(new CPF(cpf));

        Assertions.assertEquals(name, studentCreted.getName());
        Assertions.assertEquals(cpf, studentCreted.getCpf());
        Assertions.assertEquals(email, studentCreted.getEmail());
    }

}
