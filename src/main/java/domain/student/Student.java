package domain.student;

import domain.student.exceptions.PhoneException;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private CPF cpf;
    private String name;
    private Email email;

    public Student(CPF cpf, String name, Email email) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
    }

    private List<Phone> phones = new ArrayList<>();

    public void addPhone(String ddd, String number) throws PhoneException {
        this.phones.add(new Phone(ddd, number));
    }

    public String getCpf() {
        return cpf.getCpf();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email.getAddress();
    }

    public List<Phone> getPhones() {
        return phones;
    }
}
