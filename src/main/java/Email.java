import java.util.Objects;

public class Email {
    private String address;

    public Email(String address) throws EmailException {
        if (address == null || !isValid(address)) {
            throw new EmailException("email not valid");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public static boolean isValid(String address) {
        return address.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

}
