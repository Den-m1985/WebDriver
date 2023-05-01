package org.example.authentication;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class Test {

    public static void main(String[] args) throws GeneralSecurityException, IOException {

        String loginIn = "my_login";
        String passwordIn = "my_password";
        LocalStorage.saveLoginPassword(loginIn, passwordIn);

//        String[] loginAndPassword = LocalStorage.loadLoginPassword();
//        if (loginAndPassword != null) {
//            String loginOut = loginAndPassword[0];
//            String passwordOut = loginAndPassword[1];
//            // ...
//        }
    }
}
/*
В данном примере логин и пароль сохраняются в бинарный файл "login_password.bin"
с использованием 128-битного ключа и вектора инициализации. Ключ и вектор могут
быть изменены на свои. Шифрование и дешифрование данных происходят с
использованием алгоритма AES в режиме CBC с дополнением PKCS5Padding.

Для сохранения и чтения логина и пароля можно вызвать методы saveLoginPassword()
и loadLoginPassword() соответственно:


для работы с файлами и шифрованием данных, которые хорошо описаны в документации Oracle:

- Описание класса `FileInputStream`: https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html
- Описание класса `FileOutputStream`: https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html
- Описание класса `Cipher`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html
- Описание класса `SecretKeySpec`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html
- Описание класса `IvParameterSpec`: https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/IvParameterSpec.html

Также рекомендую ознакомиться с документацией по JCE (Java Cryptography Extension),
который используется для шифрования и дешифрования данных:
https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html
 */
