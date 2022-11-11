import application.student.register.StudentRegister;
import application.student.register.StudentRegisterDto;
import domain.student.exceptions.CPFException;
import domain.student.exceptions.EmailException;
import infrastructure.student.StudentRepositoryInMemory;

public class RegisterStudentByCommandLine {

    public static void main(String[] args) throws EmailException, CPFException {

        var name = "John Doe";
        var cpf = "01234567890";
        var email = "johndo@gmail.com";

        var studentRepo = new StudentRepositoryInMemory();
        var studentService = new StudentRegister(studentRepo);
        var studentDto = new StudentRegisterDto(name, cpf, email);
        studentService.execute(studentDto);

    }

}
