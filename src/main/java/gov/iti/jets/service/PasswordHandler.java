package gov.iti.jets.service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHandler {
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int HASH_LENGTH = 32;

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        // Hash the password using SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hashBytes = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));

        // Convert the hash value to a string of hexadecimal digits
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        String hashedPassword = stringBuilder.toString();
        String truncatedHashedPassword = hashedPassword.substring(0, 40); // Truncate to 40 characters
        return truncatedHashedPassword;
    }

    public static boolean verifyPassword(String inputPassword, String storedHashedPassword) throws NoSuchAlgorithmException {
        // Hash the input password using SHA-256
        MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
        byte[] hashBytes = messageDigest.digest(inputPassword.getBytes(StandardCharsets.UTF_8));

        // Convert the hash value to a string of hexadecimal digits
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : hashBytes) {
            stringBuilder.append(String.format("%02x", b));
        }
        String hashedInputPassword = stringBuilder.toString();

        // Compare the stored hashed password with the hash of the input password
        return hashedInputPassword.equals(storedHashedPassword);
    }
}
