package domain.student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import domain.student.CPF;
import domain.student.exceptions.CPFException;

public class CPFTest {

    @Test
    void shouldNotCreateCPFWithInvalidNumber() {

        CPFException thrownInvalidCPF = Assertions.assertThrows(CPFException.class, () -> {
            new CPF("00000000000000");
        });

        Assertions.assertEquals("cpf not valid", thrownInvalidCPF.getMessage());

        CPFException thrownCPFEmpty = Assertions.assertThrows(CPFException.class, () -> {
            new CPF("");
        });

        Assertions.assertEquals("cpf not valid", thrownCPFEmpty.getMessage());

        CPFException thrownCPFNull = Assertions.assertThrows(CPFException.class, () -> {
            new CPF(null);
        });

        Assertions.assertEquals("cpf not valid", thrownCPFNull.getMessage());

    }

    @Test
    void shouldCreateEmailsWithCorrectAddress() throws CPFException {

        String cpfExample = "01234567890";

        var cpf = new CPF(cpfExample);

        Assertions.assertEquals(cpfExample, cpf.getCpf());

    }

}
