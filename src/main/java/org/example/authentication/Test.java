package org.example.authentication;

import org.example.authentication.cryptClass.LoginCrypt;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Exception {

        String login = "my_login";
        String password = "my_password";

        String filePath = "credentials.txt";
        LoginStorage loginStorage = new LoginStorage();

        loginStorage.saveToFile(login, password);

        String[] log = loginStorage.readFromFile();
        System.out.println(log[0]);
        System.out.println(log[1]);

    }
}

