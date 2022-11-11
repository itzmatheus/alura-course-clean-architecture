package application.student;

import domain.student.FactoryForStudent;
import domain.student.Student;
import domain.student.exceptions.CPFException;
import domain.student.exceptions.EmailException;

public class StudentRegisterDto {

    private String name;
    private String cpf;
    private String email;

    public StudentRegisterDto(String name, String cpf, String email) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Student createStudent() throws EmailException, CPFException {
        return new FactoryForStudent()
                .withNameCPFEmail(name, cpf, email)
                .create();
    }

}
