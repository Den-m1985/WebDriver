package org.example.browser;

import org.example.TextLinks;
import org.example.authentication.LoginStorage;
import org.example.browser.chrome.XPathWait;
import org.openqa.selenium.WebElement;

public class LoginPage {


    public LoginPage() throws Exception {
        signAccount();
    }


    void signAccount() throws Exception {
        XPathWait pathWait = new XPathWait();

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

        // field Enter
        TextLinks LinksEnter = TextLinks.ENTERACCOUNT;
        WebElement enterField = pathWait.xPath(LinksEnter.getString());
        enterField.click();

    }

}
