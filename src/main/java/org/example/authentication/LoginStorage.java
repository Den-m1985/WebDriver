package org.example.authentication;

import org.example.TextLinks;
import org.example.authentication.cryptClass.LoginCrypt;
import org.openqa.selenium.WebElement;

import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;

public class LoginStorage {

    private final String ALGORITHM = "AES";
    private final String CHARSET = StandardCharsets.UTF_8.toString();
    private final String filePath;
    private final String secretKey = "my_secret_key_123";


    public LoginStorage() {
        TextLinks linksLoginFile = TextLinks.AUTHORIZATION;
       String str = linksLoginFile.getString();
        this.filePath = System.getProperty("user.home") + File.separator + str;
    }


    public void saveToFile(String login, String password) throws Exception {
        Key key = byteKey();
        LoginCrypt storage = new LoginCrypt();
        String encryptedLogin = storage.encrypt(login, key, ALGORITHM);
        String encryptedPassword = storage.encrypt(password, key, ALGORITHM);
        storage.saveCredentialsToFile(encryptedLogin, encryptedPassword, filePath);
    }


    public String[] readFromFile() throws Exception {
        LoginCrypt storage = new LoginCrypt();
        String[] credentialsFromFile = storage.readCredentialsFromFile(filePath);
        Key key = byteKey();
        if (credentialsFromFile != null) {
            String decryptedLogin = storage.decrypt(credentialsFromFile[0], key, ALGORITHM);
            String decryptedPassword = storage.decrypt(credentialsFromFile[1], key, ALGORITHM);
            String[] decryptedData = {decryptedLogin, decryptedPassword};
            return decryptedData;
        }
        return null;
    }

    public Key byteKey(){
        //Длина ключа для AES должна составлять 16, 24 или 32 байт
        byte[] keyBytes = secretKey.getBytes();
        byte[] newKeyBytes = Arrays.copyOf(keyBytes, 16);
        return new SecretKeySpec(newKeyBytes, ALGORITHM);
    }


}
/*
для работы с файлами и шифрованием данных описаны в документации Oracle:

- Описание класса `FileInputStream`: https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
- Описание класса `FileOutputStream`: https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html
- Описание класса `Cipher`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html
- Описание класса `SecretKeySpec`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html
- Описание класса `IvParameterSpec`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/IvParameterSpec.html

Документация по JCE (Java Cryptography Extension),
который используется для шифрования и дешифрования данных:
https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html
 */
