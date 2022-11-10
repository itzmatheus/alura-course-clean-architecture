package infrastructure.student;

import domain.student.PasswordEncrypt;

import java.security.MessageDigest;

public class PasswordEncryptWithMD5 implements PasswordEncrypt {
    @Override
    public String encrypt(String password) {
        try {
            var md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            var bytes = md.digest();
            var sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        }catch (Exception e) {
            throw new RuntimeException("error when try generate hash password");
        }
    }

    @Override
    public boolean isEquals(String passwordEncrypted, String password) {
        return passwordEncrypted.equals(encrypt(password));
    }
}
