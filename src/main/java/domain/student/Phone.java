package domain.student;

import domain.student.exceptions.PhoneException;

import java.util.List;

public class Phone {

    private String ddd;
    private String number;

    public Phone(String ddd, String number) throws PhoneException {
        if (ddd == null || number == null || !isValid(ddd, number)) {
            throw new PhoneException("phone not valid");
        }
        this.ddd = ddd;
        this.number = number;
    }

    public String getPhone() {
        return this.ddd + this.number;
    }

    public static boolean isValid(String ddd, String phone) {
        return (ddd.length() == 2 && (List.of(8, 9).contains(phone.length())));
    }

}
