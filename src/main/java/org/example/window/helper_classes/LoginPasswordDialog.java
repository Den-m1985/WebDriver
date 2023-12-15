package org.example.window.helper_classes;

import javax.swing.*;
import java.util.Objects;

public class LoginPasswordDialog {

    public String[] enterLoginPassword() {

        JTextField loginField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        Object[] message = {
                "Login:", loginField,
                "Password:", passwordField
        };

        ImageIcon iconLogin = new ImageIcon(Objects.requireNonNull(getClass().getResource("/enter40.png")));

        int option = JOptionPane.showOptionDialog(null, message,
                "Login and Password", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE, iconLogin, null, null);
        if (option == JOptionPane.OK_OPTION) {
            String login = loginField.getText();
            String password = new String(passwordField.getPassword());
            String[] authorizationData = {login, password};
            return authorizationData;
        } else {
            System.out.println("Login and Password dialog canceled");
        }
        return null;
    }

}
