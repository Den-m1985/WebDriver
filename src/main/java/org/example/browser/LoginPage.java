package org.example.browser;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriverWait wait;


    public LoginPage(WebDriverWait wait) throws Exception {
        this.wait = wait;

        signAccount();
    }


    void signAccount() throws Exception {

        XPathWait pathWait = new XPathWait(wait);
        LoginStorage loginStorage = new LoginStorage();

        // field Cabinet
        TextLinks LinksCabinet = TextLinks.CABINET;
        WebElement clickBay = pathWait.xPath(LinksCabinet.getString());
        clickBay.click();

        // field Login
        TextLinks LinksLogin = TextLinks.LOGINFIELD;
        WebElement loginField = pathWait.xPath(LinksLogin.getString());
        loginField.click();

        String[] decryptedData = loginStorage.readFromFile();
        loginField.sendKeys(decryptedData[0]); // enter login
        decryptedData[0] = "";

        // field Password
        TextLinks LinksPassword = TextLinks.PASSWORDFIELD;
        WebElement passwordField = pathWait.xPath(LinksPassword.getString());
        passwordField.click();

        passwordField.sendKeys(decryptedData[1]);  // enter password
        decryptedData[1] = "";
        /*
        Добавить замену пароля, чтоб не чисел в буфере.
         */


        // field Enter
        TextLinks LinksEnter = TextLinks.ENTERACCOUNT;
        WebElement enterField = pathWait.xPath(LinksEnter.getString());
        enterField.click();

    }


}
