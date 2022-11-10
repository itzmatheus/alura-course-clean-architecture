public class FactoryForStudent {

    private Student student;

    public FactoryForStudent withNameCPFEmail(String name, String cpf, String email) throws EmailException, CPFException {
        this.student = new Student(new CPF(cpf), name, new Email(email));
        return this;
    }

    public FactoryForStudent withPhone(String ddd, String number) throws PhoneException {
        this.student.addPhone(ddd, number);
        return this;
    }

    public Student create() {
        return this.student;
    }

}
