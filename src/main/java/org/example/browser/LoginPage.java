package org.example.browser;

import org.example.TextLinks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private final WebDriverWait wait;


    public LoginPage(WebDriverWait wait) {
        this.wait = wait;

        signAccount();
    }


    void signAccount() {

        XPathWait pathWait = new XPathWait(wait);

        // field Cabinet
        TextLinks LinksCabinet = TextLinks.CABINET;
        WebElement clickBay = pathWait.xPath(LinksCabinet.getString());
        clickBay.click();

        // field Login
        TextLinks LinksLogin = TextLinks.LOGINFIELD;
        WebElement loginField = pathWait.xPath(LinksLogin.getString());
        loginField.click();
        //loginField.sendKeys(ConfProperties.getProperty("login"));
        loginField.sendKeys("kashleva88@mail.ru");

        // field Password
        TextLinks LinksPassword = TextLinks.PASSWORDFIELD;
        WebElement passwordField = pathWait.xPath(LinksPassword.getString());
        passwordField.click();
        //passwordField.sendKeys(ConfProperties.getProperty("password"));
        passwordField.sendKeys("marusia");
        /*
        Добавить замену пароля, чтоб не чисел в буфере.
         */


        // field Enter
        TextLinks LinksEnter = TextLinks.ENTERACCOUNT;
        WebElement enterField = pathWait.xPath(LinksEnter.getString());
        enterField.click();

    }


}
