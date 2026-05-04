package services;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class HashService {
    private static final int SALT_LENGTH = 32;
    private static final SecureRandom secureRandom = new SecureRandom();

    public String generateSalt() {
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public String generateHash(String password, String salt) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            String saltedPassword = salt + password;
            byte[] hashBytes = digest.digest(
                    saltedPassword.getBytes(StandardCharsets.UTF_8)
            );

            return Base64.getEncoder().encodeToString(hashBytes);

        } catch (Exception e) {
            throw new RuntimeException("Could not generate password hash", e);
        }
    }

    public boolean validatePassword(String password, String salt, String storedHash) {
        String generatedHash = generateHash(password, salt);
        return constantTimeEquals(generatedHash, storedHash);
    }

    private boolean constantTimeEquals(String first, String second) {
        if (first == null || second == null) {
            return false;
        }

        byte[] firstBytes = first.getBytes(StandardCharsets.UTF_8);
        byte[] secondBytes = second.getBytes(StandardCharsets.UTF_8);

        if (firstBytes.length != secondBytes.length) {
            return false;
        }

        int result = 0;

        for (int i = 0; i < firstBytes.length; i++) {
            result |= firstBytes[i] ^ secondBytes[i];
        }

        return result == 0;
    }
}