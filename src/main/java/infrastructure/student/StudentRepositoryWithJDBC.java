package infrastructure.student;

import domain.student.*;
import domain.student.exceptions.StudentNotFoundException;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryWithJDBC implements StudentRepository {

    private final Connection connection;

    public StudentRepositoryWithJDBC(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void register(Student student) {
        try {
            var sql = "INSERT INTO STUDENT VALUES(?, ?, ?);";
            var ps = connection.prepareStatement(sql);
            ps.setString(1, student.getCpf());
            ps.setString(2, student.getName());
            ps.setString(3, student.getEmail());
            ps.execute();
            
            sql = "INSERT INTO PHONE VALUES(?, ?);";
            ps = connection.prepareStatement(sql);
            for (Phone phone: student.getPhones()) {
                ps.setString(1, phone.getDdd());
                ps.setString(2, phone.getNumber());
                ps.execute();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Student findByCPF(CPF cpf) {

        try {
            var sql = "SELECT id, name, email FROM STUDENT WHERE cpf = ?";
            var ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getCpf());

            var rs = ps.executeQuery();
            var isFind = rs.next();
            if (!isFind) {
                throw new StudentNotFoundException("user not found for this cpf: " + cpf.getCpf());
            }

            var name = rs.getString("name");
            var email = rs.getString("email");
            var studentFound = new FactoryForStudent()
                    .withNameCPFEmail(name, cpf.getCpf(), email)
                    .create();

            var id = rs.getLong("id");
            sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                var number = rs.getString("number");
                var ddd = rs.getString("ddd");
                studentFound.addPhone(ddd, number);
            }

            return studentFound;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Student> findAllStudentsRegistered() {

        try {
            var sql = "SELECT id, name, email, cpf FROM STUDENT";
            var ps = connection.prepareStatement(sql);

            var rs = ps.executeQuery();

            var students = new ArrayList<Student>();
            while (rs.next()) {

                var name = rs.getString("name");
                var email = rs.getString("email");
                var cpf = rs.getString("cpf");
                var student = new FactoryForStudent()
                        .withNameCPFEmail(name, cpf, email)
                        .create();

                var id = rs.getLong("id");
                sql = "SELECT ddd, number FROM PHONE WHERE student_id = ?";
                ps = connection.prepareStatement(sql);
                ps.setLong(1, id);
                var rsPhone = ps.executeQuery();
                while (rsPhone.next()) {
                    var number = rs.getString("number");
                    var ddd = rs.getString("ddd");
                    student.addPhone(ddd, number);
                }

                students.add(student);

            }

            return students;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
