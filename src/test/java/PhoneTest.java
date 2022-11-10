import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PhoneTest {

    @Test
    void shouldNotCreatePhoneWithInvalidNumber() {

        PhoneException thrownInvalidPhone = Assertions.assertThrows(PhoneException.class, () -> {
            new Phone("00", "299299299292929292");
        });

        Assertions.assertEquals("phone not valid", thrownInvalidPhone.getMessage());

        PhoneException thrownPhoneEmpty = Assertions.assertThrows(PhoneException.class, () -> {
            new Phone("", "");
        });

        Assertions.assertEquals("phone not valid", thrownPhoneEmpty.getMessage());

        PhoneException thrownPhoneNull = Assertions.assertThrows(PhoneException.class, () -> {
            new Phone(null, null);
        });

        Assertions.assertEquals("phone not valid", thrownPhoneNull.getMessage());

    }

    @Test
    void shouldCreateEmailsWithCorrectAddress() throws PhoneException {

        String ddd = "82";
        String number = "12345678";

        var phone = new Phone(ddd, number);

        Assertions.assertEquals(ddd + number, phone.getPhone());

    }

}
