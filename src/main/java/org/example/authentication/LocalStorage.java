package org.example.authentication;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class LocalStorage {
    private static final byte[] KEY = "my_secret_key_123".getBytes(); // 128-bit key
    private static final byte[] IV = "my_secret_iv_456".getBytes(); // 128-bit IV

    public static void saveLoginPassword(String login, String password) throws GeneralSecurityException, IOException {
        byte[] loginBytes = login.getBytes();
        byte[] passwordBytes = password.getBytes();
        byte[] encryptedLoginBytes = encrypt(KEY, IV, loginBytes);
        byte[] encryptedPasswordBytes = encrypt(KEY, IV, passwordBytes);
        try (FileOutputStream fos = new FileOutputStream(new File("login_password.bin"))) {
            fos.write(encryptedLoginBytes);
            fos.write(encryptedPasswordBytes);
        }
    }

    public static String[] loadLoginPassword() throws GeneralSecurityException, IOException {
        File file = new File("login_password.bin");
        if (!file.exists()) {
            return null;
        }
        byte[] encryptedBytes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(encryptedBytes);
        }
        byte[] decryptedBytes = decrypt(KEY, IV, encryptedBytes);
        String login = new String(decryptedBytes, 0, decryptedBytes.length / 2);
        String password = new String(decryptedBytes, decryptedBytes.length / 2, decryptedBytes.length / 2);
        return new String[]{login, password};
    }

    private static byte[] encrypt(byte[] key, byte[] iv, byte[] input) throws GeneralSecurityException {
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(iv));
        return cipher.doFinal(input);
    }

    private static byte[] decrypt(byte[] key, byte[] iv, byte[] encrypted) throws GeneralSecurityException {
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv));
        return cipher.doFinal(encrypted);
    }

}
