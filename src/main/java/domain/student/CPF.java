package domain.student;

import domain.student.exceptions.CPFException;

public class CPF {

    private String value;

    public CPF(String value) throws CPFException {
        if (value == null || !isValid(value)) {
            throw new CPFException("cpf not valid");
        }
        this.value = value;
    }

    public static boolean isValid(String value) {
        return value.length() == 11;
    }

    public String getCpf() {
        return this.value;
    }

}
