package student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import student.Email;
import student.exceptions.EmailException;

public class EmailTest {

    @Test
    void shouldNotCreateEmailsWithInvalidAddress() {

        EmailException thrownInvalidEmail = Assertions.assertThrows(EmailException.class, () -> {
            new Email("teste@");
        });

        Assertions.assertEquals("email not valid", thrownInvalidEmail.getMessage());

        EmailException thrownEmailEmpty = Assertions.assertThrows(EmailException.class, () -> {
            new Email("");
        });

        Assertions.assertEquals("email not valid", thrownEmailEmpty.getMessage());

        EmailException thrownEmailNull = Assertions.assertThrows(EmailException.class, () -> {
            new Email(null);
        });

        Assertions.assertEquals("email not valid", thrownEmailNull.getMessage());

    }

    @Test
    void shouldCreateEmailsWithCorrectAddress() throws EmailException {

        String emailExample = "user@gmail.com";

        var email = new Email(emailExample);

        Assertions.assertEquals(emailExample, email.getAddress());

    }

}
