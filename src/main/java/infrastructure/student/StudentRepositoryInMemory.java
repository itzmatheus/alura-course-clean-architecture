package infrastructure.student;

import domain.student.CPF;
import domain.student.Student;
import domain.student.StudentRepository;
import domain.student.exceptions.StudentNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryInMemory implements StudentRepository {

    private List<Student> registered = new ArrayList<>();

    @Override
    public void register(Student student) {
        this.registered.add(student);
    }

    @Override
    public Student findByCPF(CPF cpf) {
        try {
            return this.registered.stream()
                    .filter(s -> s.getCpf().equals(cpf.getCpf()))
                    .findFirst()
                    .orElseThrow(() -> new StudentNotFoundException("studet not found for this cpf: " + cpf));
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> findAllStudentsRegistered() {
        return this.registered;
    }
}
