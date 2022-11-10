package domain.student;

public interface PasswordEncrypt {

    String encrypt(String password);

    boolean isEquals(String passwordEncrypted, String password);

}
